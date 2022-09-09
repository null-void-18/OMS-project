import React from "react";
import { Link } from "react-router-dom";
import "./LoginForm.css"
function Welcome() {
    return (
        <div>
           <button className="btn"><Link to="/signin">LOGIN</Link></button>
           <button className="btn"><Link to="/signup">SIGN UP</Link></button>
        </div>
    )
}

export default Welcome