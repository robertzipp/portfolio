import HelloWorld from "./components/a6/HelloWorld";
import Practice from "./components/a6/Practice";
import Build from "./components/a6/Build";
import React from "react";
import ReactDOM from 'react-dom';
import {BrowserRouter, Routes, Route } from "react-router-dom";

class App extends React.Component  {
render() {
    return (
        <BrowserRouter>
            <div className="container">
                    <Routes>
                        <Route path="/a6/HelloWorld" element={<HelloWorld/>} />
                        <Route path="/a6/Practice" element={<Practice/>} />
                        <Route path="/" element={<Practice/>} />
                        <Route path="/a6" element={<Practice/>} />
                        <Route path="/a6/Build" element={<Build/>} />
                    </Routes>
            </div>
        </BrowserRouter>
    );
} }
ReactDOM.render(
    <App/>,
    document.getElementById('root')
);


export default App;
