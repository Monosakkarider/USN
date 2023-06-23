import { db } from "./firebaseConfig";
import { useState, useEffect } from "react";
import { collection, getDocs } from "firebase/firestore";

function useProductData() {
  const [products, setProducts] = useState([]);
  useEffect (() => {
    const fetchProducts = async () => {
      const productsCollectionRef = collection(db, "products");
      const productsSnapshot = await getDocs(productsCollectionRef);
      const productsData = productsSnapshot.docs.map((doc) => ({
        id: doc.id,
        ...doc.data(),
      }));
      setProducts(productsData);
    };
    fetchProducts();
  }, []);

  return products;
}

export default useProductData;