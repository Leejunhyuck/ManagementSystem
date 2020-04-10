import React from 'react';
import './App.css';
import {BrowserRouter as Router, Route} from 'react-router-dom'
import Main from './pages/Main';
import TList from './pages/TList';
import TRegister from './pages/TRegister';
import Nav from './components/Nav';
import Login from './pages/Login';

function App() {
  return (

    <Router>
      <Nav></Nav>
      <Route path="/" exact component ={Main}></Route>
      <Route path="/register" component ={TRegister}></Route>
      <Route path="/list/:page" component ={TList}></Route>
      <Route path="/login" component ={Login}></Route>
    </Router>
  );
}


export default App;
