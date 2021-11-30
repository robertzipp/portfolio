import React from "react";
import Styles from "./Styles";
import ReactDOM from 'react-dom';
import ConditionalOutput from "./ConditionalOutput"
import Classes from "./Classes";
import {Link} from "react-router-dom";
import TodoList from "./Todo/ToDoList";


const Practice = () => {
    return(
        <div>
        <Link to="/a6/HelloWorld">
            Hello
        </Link> |
        <Link to="/a6/Build">
            Build
        </Link>
            <h1>Practice</h1>
            <ConditionalOutput/>
            <Styles/>
            <Classes/>
            <TodoList/>
        </div>
    )
};


export default Practice;
