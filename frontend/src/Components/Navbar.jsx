import React from "react";
import {NavbarLogged} from "./NavbarLogged";
import {NavbarNotLogged} from "./NavbarNotLogged";

export function Navbar(){

        return (
            <div className="App">
                {localStorage.getItem("userInfo") != null ? <NavbarLogged/> : <NavbarNotLogged/>}
            </div>
        );
}
