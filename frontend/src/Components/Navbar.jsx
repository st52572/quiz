import React from "react";
import {NavbarLogged} from "./NavbarLogged";
import {NavbarNotLogged} from "./NavbarNotLogged";
import UserProfile from "./UserProfile";

export function Navbar(){

        return (
            <div className="App">
                {UserProfile.getId() != null && UserProfile.getId() > 0 ? <NavbarLogged/> : <NavbarNotLogged/>}
            </div>
        );
}
