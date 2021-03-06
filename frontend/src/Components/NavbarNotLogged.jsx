import {BrowserRouter as Router, Link, Route, Switch} from "react-router-dom";
import React from "react";
import {Login} from "./Login";
import {Registration} from "./Registration";

export function NavbarNotLogged() {
    return (
        <Router>
            <div>
                <ul>
                    <li>
                        <Link to="/registration">Register</Link>
                    </li>
                    <li>
                        <Link to="/login">Login</Link>
                    </li>

                </ul>

                <hr/>

                <Switch>
                    <Route exact path="/registration">
                        <Registration/>
                    </Route>

                    <Route exact path="/login">
                        <Login/>
                    </Route>

                </Switch>
            </div>
        </Router>
    );
};