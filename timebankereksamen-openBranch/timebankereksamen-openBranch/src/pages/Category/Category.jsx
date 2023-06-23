import React from "react"
import { useParams } from "react-router-dom"
import './Category.css'
import useProductData from "../../productData"
import Card from "../../components/Card/Card"

function Category() {
    const products = useProductData()
    const productData = Object.values(products)
    const { catID } = useParams()

    const thisCat = productData.filter(prod => prod.catID === (catID))
    const cards = thisCat.slice(0, 20).map(item => (
        <Card item={item} key={item.id} />
    ));
    const catTitle = catID.toUpperCase()

    return (
        <div className="categoryMain">
            <div className="categoryTitle">
                <h1>{catTitle}</h1>
            </div>
            <div className="categoryElements">
                {cards}
            </div>
        </div>
    )
}
export default Category