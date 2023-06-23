import { useState } from "react";
import { Link } from "react-router-dom";
import { createUserWithEmailAndPassword } from "firebase/auth";
import { auth } from "../../firebaseConfig";
import "./Registrer.css";

function Registrer() {
  const [registerEmail, setRegisterEmail] = useState("");
  const [registerPassword, setRegisterPassword] = useState("");

  const register = async () => {
    const confirmPassword = document.getElementById("confirmPassword").value;
    if (registerPassword !== confirmPassword) {
      alert('Passwords do not match');
      return;
    }
    try {
      const user = await createUserWithEmailAndPassword(auth,registerEmail,registerPassword);      
      window.location = "/";
    } catch (error) {
      alert(error.message);
    }
  };
  
  return (
    <div className="registrer">
      <div className='auth'>
      < h1>Register</h1>
        <div className="registration-form">
          <ul>
            <li>
              <input type="text" className="registrering_input" placeholder="Epost" onChange={(event) => {setRegisterEmail(event.target.value);}}/>
            </li>
            <li> 
              <input type="password" className="registrering_input" id="password" placeholder="Passord" onChange={(event) => {setRegisterPassword(event.target.value);}}/>
            </li>
            <li>  
              <input type="password" className="registrering_input" id="confirmPassword" placeholder="Bekreft passord"/>
            </li>
            <li>
              <button className="registrer_button" onClick={register}> Register</button>
            </li>
          </ul>  
        </div>
        <span>
          <Link to="/login">Allerede registrert?</Link>
        </span>
      </div>
    </div> 
  );
};

export default Registrer;