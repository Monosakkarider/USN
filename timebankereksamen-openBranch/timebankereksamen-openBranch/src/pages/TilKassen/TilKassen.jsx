import "./TilKassen.css";
import { React, useState } from "react";
import { Link } from "react-router-dom";
import { useCart } from "react-use-cart";
import { formatCurrency } from "../../utilities/CurrencyFormatter";
import DeleteForeverOutlinedIcon from "@mui/icons-material/DeleteForeverOutlined";
import useProductData from "../../productData";

const TilKassen = () => {
  const products = useProductData();
  const productArray = Object.values(products);
  const { emptyCart, totalItems, items, updateItemQuantity, removeItem } =
    useCart();
  return (
    <div className="handlevognOversikt">
      {items?.map((productArray) => (
        <div className="handlevognItem" key={productArray.id}>
          <img className="handlevognImage" src={productArray.img} alt="img" />
          <div className="handlevognItemTitleDescriptionPrice">
            <div className="handlevognItemTitle">
              {productArray.title.substring(0, 20)}
            </div>
            <div className="handlevognItemDescription">
              {productArray.description}
            </div>

            <div className="handlevognItemPrice">NOK {productArray.price}</div>
          </div>
          <div className="handlevognQuantity">
            <div className="handlevognIndividualTotal">
              <button
                className="handlevognQuantityUpdater"
                onClick={() =>
                  updateItemQuantity(productArray.id, productArray.quantity - 1)
                }
              >
                -
              </button>
              <p>{productArray.quantity}</p>
              <button
                className="handlevognQuantityUpdater"
                onClick={() =>
                  updateItemQuantity(productArray.id, productArray.quantity + 1)
                }
              >
                +
              </button>
            </div>
            <div className="handlevognItemDelete">
              <DeleteForeverOutlinedIcon
                className="deleteItemIcon"
                onClick={() => removeItem(productArray.id)}
              />
            </div>
          </div>
        </div>
      ))}

      {totalItems > 0 && (
        <div className="checkoutBottomPart">
          <div className="handlevognTotal">
              <u>Totalt:</u>
                {formatCurrency(
                  items.reduce((total, items) => {
                    const item = productArray.find(
                      (item) => item.id === items.id
                    );
                    return total + (item?.price || 0) * items.quantity;
                  }, 0)
                )}
            
          </div>
          <div className="paymentButtonDiv">
            <Link to="/takkForHandel">
              <button className="betalKnapp" onClick={() => emptyCart()}>
                Betal for varer
              </button>
            </Link>
          </div>

          <div className="handlevognEmpty">
            <p className="handlevognEmptyText" onClick={() => emptyCart()}>
              Tøm handlevognen
            </p>
          </div>
        </div>
      )}
    </div>
  );
};

export default TilKassen;
