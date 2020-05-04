import React from 'react';
import {Input} from "./Input";


export class Registration extends React.Component {


    constructor() {
        super();
        this.state = {user: {}}
    }

    register = () => {
        const requestOptions = {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(this.state.user)
        };
        console.log(JSON.stringify(this.state.user));
        fetch('http://localhost:8080/users/add', requestOptions)
            .then();
    };

    changeFirstName = (firstName) => {
        this.setState(prevState => {
            let user = {...prevState.user};  // creating copy of state variable jasper
            user.firstName = firstName.text;                     // update the name property, assign a new value
            return {user};                                 // return new object jasper object
        })
    };
    changeLastName = (lastName) => {
        this.setState(prevState => {
            let user = {...prevState.user};  // creating copy of state variable jasper
            user.lastName = lastName.text;                     // update the name property, assign a new value
            return {user};                                 // return new object jasper object
        })
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
                <Input type={"text"} onChange={this.changeFirstName} text={"firstName"}/>
                <Input type={"text"} onChange={this.changeLastName} text={"lastName"}/>
                <Input type={"text"} onChange={this.changeUsername} text={"username"}/>
                <Input type={"current-password"} onChange={this.changePassword} text={"password"}/>
                <button onClick={this.register}>Registrovat</button>
            </div>
        )
    }


}