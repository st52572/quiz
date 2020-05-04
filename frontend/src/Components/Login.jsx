import React from 'react';
import {Input} from "./Input";
import AuthService from "../service/AuthService";
import UserProfile from "./UserProfile";

export class Login extends React.Component {


    constructor(props) {
        super(props);
        this.state = {
            logged: false,
            user: {}
        }
    }


    login = (e) => {
        e.preventDefault();
        const credentials = {username: this.state.user.username, password: this.state.user.password};
        const requestOptions = {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify({username: credentials.username})
        };
        fetch('http://localhost:8080/users/get', requestOptions)
            .then(response => response.json())
            .then(data => {
                UserProfile.setId(data.id);
                UserProfile.setUsername(data.username);
            });
        AuthService.login(credentials).then(res => {
            if (res.data.status === 200) {
                localStorage.setItem("userInfo", JSON.stringify(res.data.result));
                window.location.replace("/tests");
            } else {
                this.setState({message: res.data.message});

            }
        });

    };


    changeUsername = (username) => {
        this.setState(prevState => {
            let user = {...prevState.user};  // creating copy of state variable jasper
            user.username = username.text;                     // update the name property, assign a new value
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

                <Input type={"text"} onChange={this.changeUsername} text={"username"}/>
                <Input type={"password"} onChange={this.changePassword} text={"password"}/>
                <button onClick={this.login}>Login</button>
            </div>
        )
    }


}