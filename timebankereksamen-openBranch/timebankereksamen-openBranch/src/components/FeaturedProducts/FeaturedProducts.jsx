import { React } from "react";
import "./FeaturedProducts.css";
import Card from "../Card/Card";
import useProductData from "../../productData";

const FeaturedProducts = ({ type }) => {
  const products = useProductData();
  const productArray = Object.values(products);
  const thisCat = productArray.filter((prod) => prod.catID === type);
  const cards = thisCat
    .slice(0, 5)
    .map((item) => <Card item={item} key={item.id} />);

  return (
    <div className="featuredProductsMain">
      <div className="featuredProductsTop">
        <h2 className="featuredProductsTitle">{type}</h2>
      </div>
      <div className="featuredProductsBottom">{cards}</div>
    </div>
  );
};

export default FeaturedProducts;
