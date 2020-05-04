import React from 'react';
import UserProfile from './UserProfile';

export class Logout extends React.Component {


    constructor(props, context) {
        super(props, context);
        this.logOut();
    }


    logOut = () =>{
        UserProfile.setId(-1);
        UserProfile.setLogin(null);
        window.location.replace("/login");
    };



    render() {
        return <h1>LOGOUT</h1>;
    }


}