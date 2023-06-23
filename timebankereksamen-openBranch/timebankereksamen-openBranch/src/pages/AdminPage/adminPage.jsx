import { useState, useEffect } from "react";
import { getFunctions, httpsCallable } from "firebase/functions";
import { getApps, getApp } from "firebase/app";
import { auth } from "../../firebaseConfig";
import "./AdminPage.css";

function AdminPage() {
  const [email, setEmail] = useState(""); 
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

  function addAdminByEmail(email) {
    if (!getApps().length) {
      getApp();
    }
    const functions = getFunctions();
    const addAdminRole = httpsCallable(functions, 'addAdminRole');
    addAdminRole({ email }).then(result => {
      alert("Ny adminbruker har fått rettigheter")
    }).catch(err => {
      alert("Bruker har ikke fått admin rettigheter")
    });
  }
  
  if (loading) {
    return <div>Loading...</div>;
  }

  if (!isAdmin) { 
    alert('Access restricted. You are not an admin.'); 
    window.location = "/";
    return <div></div>;
  }
  
  return (
      <div className="content">
        <div className="regAdmin">
          <input  type="email" placeholder="epost" onChange={e => setEmail(e.target.value)} />
          <button onClick={() => addAdminByEmail(email)}>Registrer Admin</button>
        </div>
      </div>
  );
  
}
export default AdminPage;
