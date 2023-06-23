/* eslint-disable jsx-a11y/img-redundant-alt */
/* eslint-disable no-undef */
import React, { useState, useEffect } from 'react';
import { db , auth } from "../../firebaseConfig";
import { collection, getDocs, addDoc, updateDoc, deleteDoc } from "firebase/firestore";
import { doc } from "firebase/firestore";
import useProductData from '../../productData';
import { useParams , useNavigate } from 'react-router-dom';
import "./Crud.css"

function Crud() {
    const productsCollectionRef = collection(db, "products");
    const FaneVelger = () => {
        const [page, setPage] = useState(null);      
        const handleClick = (button) => {
          switch (button) {
            case "Create":
                setPage(null)
                setPage(<Create />);
                break;
            case "Update":
                setPage(null)
                setPage(<Update />);
                break;
            case "Delete":
                setPage(null)
                setPage(<Delete />);
                break;
            default:
                setPage(null);
                break;
          }
        };
        return(
            <div>
            <button onClick={() => handleClick("Create")}>Legg Til</button>
            <button onClick={() => handleClick("Update")}>Rediger</button>
            <button onClick={() => handleClick("Delete")}>Slett</button>
            <div>{page}</div>
            </div>
        ); 
    };

    const Create = () => {
        const clearCreate = () => {
            setNewId("");
            setNewCatID("");
            setNewImg("");
            setNewImg2("");
            setNewTitle("");
            setNewPrice(0);
            setNewSize("");
            setNewDescription("");
        }
        const createProduct = async () => {
            if (newId === "") {
                alert("Vennligst fyll ut Id felt");
                return;
            }
            if (newCatID === "") {
                alert("Vennligst velg kategori");
                return;
            }
            if (newImg === "") {
                alert("Vennligst fyll ut bilde felt");
                return;
            }
            if (newTitle === "") {
                alert("Vennligst fyll ut tittel felt");
                return;
            }
            if (newPrice === 0) {
                alert("Vennligst fyll ut pris felt");
                return;
            }
            if (newDescription === "") {
                alert("Vennligst fyll ut beskrivelsen");
                return;
            }
            
            await addDoc(productsCollectionRef, {
            id: Number(newId),
            catID: newCatID,
            img: newImg,
            img2: newImg2,
            title: newTitle,
            price: Number(newPrice),
            size: Array.isArray(newSize) ? newSize : newSize.split(",").map((size) => size.trim()),
            description: newDescription,
            
            });
            clearCreate();
            alert("Produktet er lagt til");
            
        };
        const [newId, setNewId] = useState(0);
        const [newCatID, setNewCatID] = useState("");
        const [newImg, setNewImg] = useState("");
        const [newImg2, setNewImg2] = useState("");
        const [newTitle, setNewTitle] = useState("");
        const [newPrice, setNewPrice] = useState(0);
        const [newSize, setNewSize] = useState("");
        const [newDescription, setNewDescription] = useState("");
        
        return (
            <div>
                <h1>Legg til ny vare</h1>
                <input type="number" placeholder="ID" onChange={(e) => setNewId(e.target.value)} required />
                <select type="text" placeholder="Kategori" defaultValue= {"default"} onChange={(e) => setNewCatID(e.target.value)}>
                    <option value={"default"} disabled>Velg kategori</option>
                    <option value="padel">Padel</option>
                    <option value="import">Import</option>
                    <option value="klær">Klær</option>
                    <option value="sko">Sko</option>
                    <option value="salg">Salg</option>
                    <option value="tilbehør">Tilbehør</option>
                </select>
                <input type="text" placeholder="Bilde" onChange={(e) => setNewImg(e.target.value)} />
                <input type="text" placeholder="Bilde2" onChange={(e) => setNewImg2(e.target.value)} />
                <br/>
                <input type="text" placeholder="tittel" onChange={(e) => setNewTitle(e.target.value)} />
                <input type="number" placeholder="Pris" onChange={(e) => setNewPrice(e.target.value)} />
                <select type="text" placeholder="Størrelser" defaultValue= {"default"} onChange={(e) => setNewSize(e.target.value)}>
                    <option value={"default"} disabled>Velg størrelseform</option>
                    <option value={['XS', 'S', 'M', 'L', 'XL']} selected>XS, S, M, L, XL </option>
                    <option value={['38', '39', '40', '41', '42', '43', '44', '45']}>Skostørrelser</option>
                    <option value={['']}>Ingen</option>
                </select>
                <input type="text" placeholder="Beskrivelse" onChange={(e) => setNewDescription(e.target.value)} />
                <button onClick={createProduct}>Legg til produkt</button>
                <br />
            </div>
            );
    };      

    const Update = () => {
        const [searchId, setSearchId] = useState("");
        const [updatedCatID, setUpdatedCatID] = useState("");
        const [updatedImg, setUpdatedImg] = useState("");
        const [updatedImg2, setUpdatedImg2] = useState("");
        const [updatedTitle, setUpdatedTitle] = useState("");
        const [updatedPrice, setUpdatedPrice] = useState(0);
        const [updatedSize, setUpdatedSize] = useState("");
        const [updatedDescription, setUpdatedDescription] = useState("");
        const [currentProduct, setCurrentProduct] = useState(null);
        const clear = () => {
            setCurrentProduct(null);
            setUpdatedCatID("");
            setUpdatedImg("");
            setUpdatedImg2("");
            setUpdatedTitle("");
            setUpdatedPrice(0);
            setUpdatedSize("");
            setUpdatedDescription("");
        }
        const searchProduct = async () => {
            const querySnapshot = await getDocs(productsCollectionRef);
            let foundProduct = false;
            querySnapshot.forEach((doc) => {
            const product = doc.data();
            
            if (product.id === parseInt(searchId)) {
                setCurrentProduct(product);
                setUpdatedCatID(product.catID);
                setUpdatedImg(product.img);
                setUpdatedImg2(product.img2);
                setUpdatedTitle(product.title);
                setUpdatedPrice(product.price);
                setUpdatedSize(product.size);
                setUpdatedDescription(product.description);
                foundProduct = true;
                return;
            } 
        });
        if (!foundProduct) {
            clear();
            };
        };
        const updateProduct = async () => {
            const querySnapshot = await getDocs(productsCollectionRef);
            querySnapshot.forEach((queryDocSnapshot) => {
              const product = queryDocSnapshot.data();
              if (product.id === parseInt(searchId)) {
                const productId = queryDocSnapshot.id;
                const updatedProduct = {
                  catID: updatedCatID || product.catID,
                  img: updatedImg || product.img,
                  img2: updatedImg2 || product.img2,
                  title: updatedTitle || product.title,
                  price: updatedPrice || product.price,
                  size: Array.isArray(updatedSize) ? updatedSize : updatedSize.split(",").map((size) => size.trim()) || product.size,
                  description: updatedDescription || product.description,
                };
          
                const productDocRef = doc(db, "products", productId);
                updateDoc(productDocRef, updatedProduct)
                  .then(() => {
                    alert("Produktet har blitt oppdatert");
                    clear();
                  })
                  .catch((error) => {
                    alert("Produkter har ikke blitt oppdatert")
                  });
              }
            });
          };
          
        return (
            <div className="crudUpdate">
                <div className="crudUpdateFirst">
                <h1>Rediger vare</h1>
                
                <label>Produkt ID</label>
                <div>
                <input style={{width:100}} type="text" placeholder="Søk med ID" onChange={(e) => setSearchId(e.target.value)} value={searchId}/>
                <button onClick={searchProduct}>Søk</button>
                </div>
                <div className="crudUpdateFirstLabelFirst">
                <label style={{marginRight:48}}>Kategori</label>
                <label style={{marginRight:64}}>Bilde 1</label>
                <label>Bilde 2</label>
                </div>
                <div className="crudUpdateFirstInputFirst">
                <select style={{width:100}} type="text" placeholder="Ny kategori" defaultValue= {"default"} value={updatedCatID} onChange={(e) => setUpdatedCatID(e.target.value)}>
                    <option value={"default"} disabled>Velg kategori</option>
                    <option value="padel">Padel</option>
                    <option value="import">Import</option>
                    <option value="klær">Klær</option>
                    <option value="sko">Sko</option>
                    <option value="salg">Salg</option>
                    <option value="tilbehør">Tilbehør</option>
                </select>

                <input style={{width:100}} type="text" placeholder="Ny bilde" value={updatedImg} onChange={(e) => setUpdatedImg(e.target.value)} />
                <input style={{width:100}} type="text" placeholder="Ny bilde2" value={updatedImg2} onChange={(e) => setUpdatedImg2(e.target.value)} />
                </div>
                <div className="crudUpdateFirstLabelSecond">
                <label style={{marginRight:72}}>Tittel</label>
                <label style={{marginRight:82}}>Pris</label>
                <label>Størrelse</label>
                </div>
                <div className="crudUpdateFirstInputSecond">
                <input style={{width:100}} type="text" placeholder="Ny tittel" value={updatedTitle} onChange={(e) => setUpdatedTitle(e.target.value)} />
                <input style={{width:100}} type="number" placeholder="Ny pris" value={updatedPrice} onChange={(e) => setUpdatedPrice(e.target.value)} />

                <select style={{width:140}} type="text" placeholder="Ny størrelser" defaultValue={"default"} value={updatedSize} onChange={(e) => setUpdatedSize(e.target.value)}>
                    <option value={"default"} disabled>Velg størrelseform</option>
                    <option value={['XS', 'S', 'M', 'L', 'XL']}>XS, S, M, L, XL </option>
                    <option value={['38', '39', '40', '41', '42', '43', '44', '45']}>Skostørrelser</option>
                    <option value={['']}>Ingen</option>
                </select>
                </div>
                <label>Beskrivelse</label>
                <textarea style={{width:200,height:100}} placeholder="Ny beskrivelse" value={updatedDescription} onChange={(e) => setUpdatedDescription(e.target.value)} />
                
                <button style={{width:100}}onClick={updateProduct}>Oppdater</button>
                </div>
                {currentProduct && (
                    <div className="crudProdDetails">
                        <h2>Produktdetaljer:</h2>
                        <p>ID: {currentProduct.id}</p>
                        <p>Kategori: {currentProduct.catID}</p>
                        <p>Bilde: <img style={{ width: '200px', height: '200px' }} src={currentProduct.img} alt="Product Image" /></p>
                        <p>Bildelink: {currentProduct.img}</p>
                        <p>Tittel: {currentProduct.title}</p>
                        <p>Pris: {currentProduct.price}</p>
                        <p>Størrelse: {currentProduct.size}</p>                        
                        <p>Beskrivelse: {currentProduct.description}</p>
                    </div>
                )}
                
            </div>
            );
    };

    const Delete = () => {
        const [deleteSearchId, setDeleteSearchId] = useState("");
        const [deletedTitle, setDeleteTitle] = useState("");
        const [currentProduct, setCurrentProduct] = useState(null);
        const deleteSearchProduct = async () => {
            const querySnapshot = await getDocs(productsCollectionRef);
            querySnapshot.forEach((queryDocSnapshot) => {
            const product = queryDocSnapshot.data();
            if (product.id === parseInt(deleteSearchId)) {
                setDeleteTitle(product.title);
                setCurrentProduct(product);
            }
            });
        };
        const clear = () => {
            setCurrentProduct(null);
            setDeleteSearchId("");
            setDeleteTitle("");
        }

        const deleteProduct = async () => {
            const querySnapshot = await getDocs(productsCollectionRef);
            querySnapshot.forEach((queryDocSnapshot) => {
            const product = queryDocSnapshot.data();
            if (product.id === parseInt(deleteSearchId)) {
                const productId = queryDocSnapshot.id;
                const productDocRef = doc(db, "products", productId);
                
                deleteDoc(productDocRef)
                .then(() => {
                    alert("Produkter har blitt fjernet")
                    clear();
                })
                .catch((error) => {
                    console.error("Error deleting product:", error);
                });
            }
            });
        };
        return (
                <div className = "crudDelete">
                    <div className="crudDeleteFirst">
                        <h1>Slett vare</h1>
                    
                        <label>Produkt ID</label>
                        <div>
                            <input type="number" placeholder="Søk med ID" onChange={(e) => setDeleteSearchId(e.target.value)} value={deleteSearchId}/>
                            <button onClick={deleteSearchProduct}>Søk</button>
                        </div>

                        <label> Varenavn</label>
                        <div> 
                            <input type="text" placeholder="Tittel" value={deletedTitle} onChange={(e) => setDeleteTitle(e.target.value)} />
                            <button onClick ={deleteProduct}>Slett</button>
                        </div>

                    </div>
                    {currentProduct && (
                        <div className="crudProdDetails">
                            <h2>Produktdetaljer:</h2>
                            <p>ID: {currentProduct.id}</p>
                            <p>Kategori: {currentProduct.catID}</p>
                            <p>Bilde: <img style={{ width: '200px', height: '200px' }} src={currentProduct.img} alt="Product Image" /></p>
                            <p>Bildelink: {currentProduct.img}</p>
                            <p>Tittel: {currentProduct.title}</p>
                            <p>Pris: {currentProduct.price}</p>
                            <p>Størrelse: {currentProduct.size}</p>
                            <p>Beskrivelse: {currentProduct.description}</p>
                        </div>
                    )}
                </div>
        );
    };    

    const productList = useProductData();
    const productArray = Object.values(productList);
    const { id } = useParams();

    useEffect(() => {
    if (id) {
        const product = productArray.find((prod) => prod.id === parseInt(id));
        setCurrentProduct(product);
    }
    }, [id, productArray]);     
    
      

    return (
        <div className="crudMain">
            {FaneVelger()}
        </div>
    );
    }

    export default Crud;