import {BrowserRouter as Router, Link, Route, Switch} from "react-router-dom";
import {CreateTest} from "./CreateTest";
import {Tests} from "./Tests";
import {Logout} from "./Logout";
import {Test} from "./Test";
import React from "react";

export function NavbarLogged() {
    return (
        <Router>
            <div>
                <ul>
                    <li>
                        <Link to="/createTest">CreateTest</Link>
                    </li>
                    <li>
                        <Link to="/tests">Tests</Link>
                    </li>
                    <li>
                        <Link to="/logout">LogOut</Link>
                    </li>

                </ul>

                <hr/>
                <Switch>
                    <Route exact path="/createTest">
                        <CreateTest/>
                    </Route>
                    <Route exact path="/tests">
                        <Tests/>
                    </Route>
                    <Route path="/logout">
                        <Logout/>
                    </Route>
                    <Route path="/test/:id" render={(props) => <Test {...props} />}/>
                </Switch>
            </div>
        </Router>

    );
}