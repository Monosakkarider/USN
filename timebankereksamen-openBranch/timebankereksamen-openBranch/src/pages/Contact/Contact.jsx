import { send } from "emailjs-com";
import {  useState } from "react";
import "./Contact.css";
import React from "react"

function Contact (){
    const [toSend, setToSend] = useState({
      name: '',
      address: '',
      zipcode: '',
      postplace: '',
      private_email: '',
      phonenumber: '',
      message:'',
    });
  
    const onSubmit = (e) => {
      e.preventDefault();
      send(
        'service_1l66qw9',
        'template_sjo0sep',
        toSend,
        'oAcPf2Hkn93AInceM'
      )
      alert('Skjemaet er sendt');
      setToSend({
        name: '',
        address: '',
        zipcode: '',
        postplace: '',
        private_email: '',
        phonenumber: '',
        message:'',
      })
        
    };
  
    const handleChange = (e) => {
      setToSend({ ...toSend, [e.target.name]: e.target.value });
    };
    return (
      <div className="contact">
        <h2>Kontakt oss!</h2>
        <form className="contactForm" onSubmit={onSubmit}>
          <input 
            className="textBoxContact"
            type="text" 
            placeholder="Ditt navn" 
            name="name" 
            value={toSend.name} 
            onChange={handleChange}
            required/>
          <br/>
          <input 
            className="textBoxContact"
            type="text" 
            placeholder="Adresse" 
            name="address" 
            value={toSend.address} 
            onChange={handleChange}
            required/>
          <br/>
          <input 
            className="zip" 
            type="text" 
            placeholder="Postnr" 
            name="zipcode" 
            value={toSend.zipcode} 
            onChange={handleChange}
            required/>
          <input 
            className="location" 
            type="text" 
            placeholder="Poststed" 
            name="postplace" 
            value={toSend.postplace} 
            onChange={handleChange}
            required/>
          <br/>
          <input 
            className="textBoxContact"
            type="text" 
            placeholder="Din e-post" 
            name="private_email" 
            value={toSend.private_email} 
            onChange={handleChange} 
            required/>
          <br/>
          <input 
            className="textBoxContact"
            type="text" 
            placeholder="Telefonnummer" 
            name="phonenumber" 
            value={toSend.phonenumber} 
            onChange={handleChange} 
            required/>
          <br/>
          <textarea 
            className="textAreaContact" 
            placeholder="Melding" 
            name="message" 
            value={toSend.message} 
            onChange={handleChange}
            required/>
          <br/>
          <button type="submit">Send</button>
        </form>
      </div>
    );
};

export default Contact;