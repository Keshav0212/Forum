import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Login from './LoginSignup'
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";

function App() {
  

  return (
    <>
      <Router>
      <Routes>
        {/* <Route path="/" element={<Home />} /> */}
        <Route path="/" element={<Login />} />
      </Routes>
    </Router>
      
    </>
  )
}

export default App
