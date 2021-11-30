import React from "react";
import ReactDOM from 'react-dom';
import {Link} from "react-router-dom";

const HelloWorld = () => {
    return(
        <div>
        <Link to="/a6/Build">
            Build
        </Link> |
        <Link to="/a6/Practice">
            Practice
        </Link>
    <h1>Hello World!</h1>
        </div>
    )
};




export default HelloWorld;
