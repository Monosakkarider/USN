import React from 'react';
import "./Card.css";
import { Link } from 'react-router-dom';

const Card = ({item}) => {
    const handleClick = () => {
        window.scrollTo({
            top: 0, behavior: 'instant'
        });
      }

    return (
        <div key={item.id}>
        <Link to={`/product/${item.id}`} onClick={handleClick}>
        <div className="cardMain">
            <div className="cardImageMain">
                <img src={item.img} alt={item.title} className="cardImg"/>
            </div>
            <div className="cardTitle">
                <h3>{item.title}</h3>
            </div>
            <div className="cardPrice">
                <h5>NOK {item.price}</h5>
            </div>
        </div>
        </Link>
        </div>
        
    );
}

export default Card;