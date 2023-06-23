import { React, useState } from "react";
import "./Product.css";
import { useParams } from "react-router-dom";
import useProductData from "../../productData";
import { useCart } from "react-use-cart";

function Product() {
  const products = useProductData();
  const productArray = Object.values(products);
  const { addItem } = useCart();
  const { id } = useParams();
  const thisProduct = productArray.find((prod) => prod.id === parseInt(id));
  const [selectedImage, setSelectedImage] = useState("");

  return (
    <>
      {thisProduct && (
        <div className="productPage">
          <div className="productPageProductHighlight">
            <div className="productPageMainImg">
              <img
                src={thisProduct[`img${selectedImage}`]}
                alt={thisProduct.title}
                className="productPageImg"
              />
            </div>
            {thisProduct.img && (
              <div className="productPageSecondaryImg">
                <img
                  src={thisProduct.img}
                  alt={thisProduct.title}
                  className="productPageImg2"
                  onClick={() => setSelectedImage("")}
                />
                {thisProduct.img2 && (
                  <img
                    src={thisProduct.img2}
                    alt={thisProduct.title}
                    className="productPageImg2"
                    onClick={() => setSelectedImage(2)}
                  />
                )}
                {thisProduct.img3 && (
                  <img
                    src={thisProduct.img3}
                    alt={thisProduct.title}
                    className="poductPageImg2"
                    onClick={() => setSelectedImage(3)}
                  />
                )}
              </div>
            )}
          </div>
          <div className="productPageProductInfo">
            <div className="productPageTitle">
              <h3>{thisProduct.title}</h3>
            </div>
            <div className="productPageCategory">
              <u>{thisProduct.catID.toUpperCase()}</u>
            </div>
            <div className="productPagePrice">
              <p>{thisProduct.price} NOK</p>
            </div>
            {thisProduct.size && (
              <div className="productPageSize">
                <select>
                  {thisProduct.size.map((size) => (
                    <option value={size}>{size}</option>
                  ))}
                </select>
              </div>
            )}
            <div className="productPageDescription">
              <p>{thisProduct.description}</p>
            </div>
            <div>
              {[thisProduct].map((item) => (
                <div key={item.id}>
                  <button
                    className="productPageAddToCart"
                    onClick={() => addItem(thisProduct)}
                  >
                    Legg til i handlevogn
                  </button>
                </div>
              ))}
            </div>
          </div>
        </div>
      )}
    </>
  );
}

export default Product;