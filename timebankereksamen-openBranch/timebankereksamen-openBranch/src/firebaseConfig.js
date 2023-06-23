import { initializeApp } from "firebase/app";
import { getDatabase } from "firebase/database";
import { getApps, getApp } from "firebase/app";
import { getFirestore } from "@firebase/firestore";
import 'firebase/auth';
import { getAuth } from 'firebase/auth';

const firebaseConfig = {
    //No you can't have my firebase config
};

const app = initializeApp(firebaseConfig);
const db = getFirestore(app);
const auth = getAuth(app);

export {db, auth};
