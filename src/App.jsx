import { useState } from 'react'
import './App.css'
import './Components/home.css'
import Login from './LoginSignup'
import Header from './Components/Header';

import { BrowserRouter as Router, Route, Routes } from "react-router-dom";

function App() {
  

  return (
    <>
      <Router>
      <Routes>
        {/* <Route path="/" element={<Home />} /> */}
        <Route path="/" element={<Login />} />
        <Route path="/home" element={<Header />} />
      </Routes>
    </Router>
      
    </>
  );
}

export default App
