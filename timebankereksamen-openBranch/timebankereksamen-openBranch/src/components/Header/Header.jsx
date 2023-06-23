import { React, useState, useEffect } from "react";
import { Link } from "react-router-dom";
import { signOut } from "firebase/auth";
import { auth } from "../../firebaseConfig";
import "./Header.css";
import Cart from "../Cart/Cart";
import ShoppingCartOutlinedIcon from "@mui/icons-material/ShoppingCartOutlined";
import Modal from "@mui/material/Modal";
import Button from "@mui/material/Button";

import { useCart } from "react-use-cart";

const Header = () => {
  /* Cart*/
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);
  const [open, setOpen] = useState(false);
  const { totalItems } = useCart();
  const [user, setUser] = useState(null);
  const [tokenResult, setTokenResult] = useState(null);

  const handleClick = () => {
    window.scrollTo({
      top: 0,
      behavior: "instant",
    });
  };

  useEffect(() => {
    const unsubscribe = auth.onAuthStateChanged((currentUser) => {
      setUser(currentUser);
      if (currentUser) {
        currentUser.getIdTokenResult().then((result) => {
          setTokenResult(result);
        });
      } else {
        setTokenResult(null);
      }
    });
    return unsubscribe;
  }, []);

  useEffect(() => {
    const unsubscribe = auth.onAuthStateChanged((currentUser) => {
      setUser(currentUser);
    });
    return unsubscribe;
  }, []);

  const logout = async () => {
    await signOut(auth);
  };

  const homeLogoClick = async () => {
    window.location = "/";
  };

  return (
    <div className="Header">
      <div className="headerLogo">
        <img
          alt="Shop Logo"
          className="Logo"
          src="https://svgur.com/i/qzN.svg"
          onClick={homeLogoClick}
        />
      </div>
      <div className="headerMiddleSection">
        <div className="headerNavBar">
          <div className="headerLinkOne">
            <Link to="/category/padel" onClick={handleClick}>
              Padel
            </Link>
          </div>
          <div className="headerLinkTwo">
            <Link to="/category/import" onClick={handleClick}>
              Import
            </Link>
          </div>
          <div className="headerLinkThree">
            <Link to="/category/klær" onClick={handleClick}>
              Klær
            </Link>
          </div>
          <div className="headerLinkFour">
            <Link to="/category/sko" onClick={handleClick}>
              Sko
            </Link>
          </div>
          <div className="headerLinkFive">
            <Link to="/category/salg" onClick={handleClick}>
              Salg
            </Link>
          </div>
          <div className="headerLinkSix">
            <Link to="/category/tilbehør" onClick={handleClick}>
              Tilbehør
            </Link>
          </div>
        </div>
      </div>
      <div className="topRight">
        {user ? (
          <div>
            {tokenResult.claims.admin == true ? (
              <>
                <Link to="/crudAccess">CRUD</Link>
                <Link to="/adminPage">Admin</Link>
                <a href="#">{user.email}</a>
                <a href="#" onClick={logout}>
                  Logg ut
                </a>
              </>
            ) : (
              <>
                <a href="#">{user.email}</a>
                <a href="#" onClick={logout}>
                  Logg ut
                </a>
              </>
            )}
          </div>
        ) : (
          <div className="headerLoggInn">
            <Link to="/login">Logg inn</Link>
            <Link to="/registrer">Registrer</Link>
          </div>
        )}    
        <div className="headerCart">
          <Button className="headerCartLogo" onClick={handleOpen}>
            <ShoppingCartOutlinedIcon cursor="pointer" fontSize="large" />
            {totalItems > 0 && (
              <div className="cartTotalItems">{totalItems}</div>
            )}
          </Button>
        </div>
      </div>
      
      <Modal open={open} onClose={handleClose}>
        <Cart />
      </Modal>
      
    </div>
  );
};

export default Header;
