import firebase from 'firebase/compat/app';
import 'firebase/compat/auth';

// reason to use .env.local to store the firebase keys: easy to switch between Dev and Production version

const app = firebase.initializeApp({

    apiKey: "AIzaSyD78pLzsmdHTTKHKyM0InAQx_qtR_UAipQ",
    authDomain: "fir-auth-test-01.firebaseapp.com",
    databaseURL: "https://fir-auth-test-01.firebaseio.com",
    projectId: "fir-auth-test-01",
    storageBucket: "fir-auth-test-01.appspot.com",
    messagingSenderId: "469744954418",
    appId: "1:469744954418:web:06a264cf1c769a986da02b",
    measurementId: "G-Z14C8J5QGH"
});

// export a variable for authentication
export const auth = app.auth() // built in function of app (firebase.initializeApp)

export default app;