import React from 'react';
import {Input} from "./Input";
import UserProfile from './UserProfile';

export class Login extends React.Component {


    constructor() {
        super();
        this.state = {user: {}}
    }


    login = ()=>{

        const requestOptions = {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(this.state.user)
        };
        fetch('http://localhost:8080/login', requestOptions)
            .then(response => response.json())
            .then(data => {
                UserProfile.setId(data.id);
                UserProfile.setLogin(data.login)
            });
    };

    changeLogin = (login) => {
        this.setState(prevState => {
            let user = {...prevState.user};  // creating copy of state variable jasper
            user.login = login.text;                     // update the name property, assign a new value
            return {user};                                 // return new object jasper object
        })
    };

    changePassword = (password) => {
        this.setState(prevState => {
            let user = {...prevState.user};  // creating copy of state variable jasper
            user.password = password.text;                     // update the name property, assign a new value
            return {user};                                 // return new object jasper object
        })
    };

    render() {
        return (
            <div>
                <Input type={"text"} onChange={this.changeLogin} text={"login"}/>
                <Input type={"password"} onChange={this.changePassword} text={"password"}/>
                <button onClick={this.login}>Login</button>
            </div>
        )
    }


}