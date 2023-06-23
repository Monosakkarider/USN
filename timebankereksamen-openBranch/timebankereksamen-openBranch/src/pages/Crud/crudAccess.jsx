import { useState, useEffect } from "react";
import { auth } from "../../firebaseConfig";
import Crud from './crud'

function CrudAccess() {
    const [isAdmin, setIsAdmin] = useState(false);
    const [loading, setLoading] = useState(true); 
    useEffect(() => {
      const unsubscribe = auth.onAuthStateChanged((currentUser) => {
        if (currentUser) {
          currentUser.getIdTokenResult().then((result) => {
            setIsAdmin(result.claims.admin === true);
            setLoading(false); 
          });
        } else {
          setIsAdmin(false);
          setLoading(false); 
        }
      });
      return unsubscribe;
    }, []);
  
    if (loading) {
      return <div>Loading...</div>;
    }
  
    if (!isAdmin) { 
      alert('Access restricted. You are not an admin.'); // new
      window.location = "/";
      return <div></div>;
    }

    return (
        <div className="content">
            <Crud/>
        </div>
  );
}
export default CrudAccess;