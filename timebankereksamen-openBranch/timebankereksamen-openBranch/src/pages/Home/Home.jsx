import React from "react";
import "./Home.css";
import FeaturedProducts from "../../components/FeaturedProducts/FeaturedProducts";
import { Link } from "react-router-dom";

const Home = () => {
  const handleClick = () => {
    window.scrollTo({
      top: 0,
      behavior: "instant",
    });
  };

  return (
    <div className="homePage">
      <div className="homePageBanner">
        <Link
          to="/category/padel"
          className="homePageBannerLink"
          onClick={handleClick}
        >
          <img
            src="https://svgur.com/i/rL2.svg"
            alt="homeBanner"
            className="homeBannerImg"
          />
        </Link>
      </div>
      <FeaturedProducts type="salg" />
      <div className="seMer">
        <Link to="/category/salg" onClick={handleClick}>
          <button className="seMerKnapp">Se mer</button>
        </Link>
      </div>
      <FeaturedProducts type="padel" />
      <div className="seMer">
        <Link to="/category/padel" onClick={handleClick}>
          <button className="seMerKnapp">Se mer</button>
        </Link>
      </div>
      <FeaturedProducts type="import" />
      <div className="seMer">
        <Link to="/category/import" onClick={handleClick}>
          <button className="seMerKnapp">Se mer</button>
        </Link>
      </div>
      <FeaturedProducts type="klær" />
      <div className="seMer">
        <Link to="/category/klær" onClick={handleClick}>
          <button className="seMerKnapp">Se mer</button>
        </Link>
      </div>
      <FeaturedProducts type="sko" />
      <div className="seMer">
        <Link to="/category/sko" onClick={handleClick}>
          <button className="seMerKnapp">Se mer</button>
        </Link>
      </div>
      <FeaturedProducts type="tilbehør" />
      <div className="seMer">
        <Link to="/category/tilbehør" onClick={handleClick}>
          <button className="seMerKnapp">Se mer</button>
        </Link>
      </div>
    </div>
  );
};

export default Home;