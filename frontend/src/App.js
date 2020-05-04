import React from 'react';
import './App.css';
import {Navbar} from "./Components/Navbar"
import 'bootstrap/dist/css/bootstrap.min.css';

export class App extends React.Component {

    render() {
        return (
            <div className="App">
                <div>
                    <h2>Quizer!</h2>
                    <Navbar/>
                </div>
            </div>
        );
    }


}