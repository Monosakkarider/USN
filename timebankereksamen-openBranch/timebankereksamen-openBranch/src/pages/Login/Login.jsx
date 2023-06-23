import { useState } from "react";
import { Link } from "react-router-dom";
import {signInWithEmailAndPassword,onAuthStateChanged} from "firebase/auth";
import { auth } from "../../firebaseConfig";
import "./Login.css";

function Login(onUserLogin) {
    const [loginEmail, setLoginEmail] = useState("");
    const [loginPassword, setLoginPassword] = useState("");
    const [setUser] = useState({});
    onAuthStateChanged(auth, (currentUser) => {
        setUser(currentUser);
    });

    const loginUser = async () => {
        try {
          const user = await signInWithEmailAndPassword(
            auth,
            loginEmail,
            loginPassword
        );
            window.location = "/";
        } catch (error) {
            alert("Fyll ut riktig informasjon");
            
        }
    };
  return (
    <div className='login'>
      <div className='auth'>
        <h1>Logg inn</h1>
        <div className="registration-form">
          <ul>
            <li>
              <input type="text" className="login_input" placeholder="Epost" onChange={(event) => { setLoginEmail(event.target.value);}}/>
            </li>
            <li> 
            <input type="password" className="login_input" placeholder="Passord"  onChange={(event) => {setLoginPassword(event.target.value);}}/>
            </li>
            <li>
              <button className="login_button" onClick={loginUser}> Logg inn</button>
            </li>
          </ul>  
        </div>
        <span>
          <Link to="/registrer">Registrer bruker</Link>
        </span>
      </div>
    </div>     
  );
};
export default Login;