import { React, useState } from "react";
import "./Cart.css";
import { Link } from "react-router-dom";
import DeleteForeverOutlinedIcon from "@mui/icons-material/DeleteForeverOutlined";
import { useCart } from "react-use-cart";
import { formatCurrency } from "../../utilities/CurrencyFormatter";
import useProductData from "../../productData";

function Cart() {
  const products = useProductData();
  const { emptyCart, totalItems, items, updateItemQuantity, removeItem } =
    useCart();

  return (
    <div className="cartMain">
      <div className="cartTitle">Handlevogn ({totalItems})</div>

      {items?.map((item) => (
        <div className="cartItem" key={item.id}>
          <img className="cartImage" src={item.img} alt="img" />
          <div className="cartItemTitleDescriptionPrice">
            <div className="cartItemTitle">{item.title.substring(0, 20)}</div>

            <div className="cartItemPrice">NOK {item.price}</div>
          </div>
          <div className="cartQuantity">
            <button
              className="cartQuantityUpdater"
              onClick={() => updateItemQuantity(item.id, item.quantity - 1)}
            >
              -
            </button>
            <p>{item.quantity}</p>
            <button
              className="cartQuantityUpdater"
              onClick={() => updateItemQuantity(item.id, item.quantity + 1)}
            >
              +
            </button>
            <div className="cartItemDelete">
              <DeleteForeverOutlinedIcon onClick={() => removeItem(item.id)} />
            </div>
          </div>
        </div>
      ))}
      {totalItems > 0 && (
        <div>
          <div className="cartTotal">
            <u>Totalt:</u>
                {formatCurrency(
                  items.reduce((total, items) => {
                    const item = products.find((item) => item.id === items.id);
                    return total + (item?.price || 0) * items.quantity;
                  }, 0)
                )}
          </div>
          <div className="cartToCheckout">
            <Link to="/tilKassen" onClick={() => Cart.close()}>
              <button>Fortsett til betaling</button>
            </Link>
          </div>
          <div className="cartEmpty">
            <p className="cartEmptyText" onClick={() => emptyCart()}>
              Tøm handlevognen
            </p>
          </div>
        </div>
      )}
    </div>
  );
}
export default Cart;
