import React, { useState } from "react";
import { useNavigate } from "react-router-dom"; // Import useNavigate hook
import user_icon from "./assets/profile_name.png";
import phone_icon from "./assets/phone.svg";
import email_icon from "./assets/user_name.svg";
import password_icon from "./assets/password.svg";
import "./LoginSignup.css";

function Login() {
  const [action, setAction] = useState("Sign Up");
  const navigate = useNavigate(); // Initialize useNavigate

  const handleSubmit = () => {
    const formData = {
      username: "user", // Replace with actual form values
      password: "password",
    };

    // Determine the URL based on the action (Login or Sign Up)
    const url =
      action === "Login"
        ? "http://localhost:8080/users/login"
        : "http://localhost:8080/users/register"; // URL for Sign Up

    // Make the request to your backend
    fetch(url, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(formData),
    })
      .then((response) => response.json())
      .then((data) => {
        console.log(data); // Handle server response
        navigate("/home"); // Navigate after successful response
      })
      .catch((error) => {
        console.error("Error:", error); // Handle error
      });
  };

  return (
    <div className="container">
      <div className="header">
        <div className="text">{action}</div>
        <div className="underline"></div>
      </div>

      <div className="inputs">
        {action === "Login" ? null : (
          <div className="extra-inputs">
            <div className="input">
              <img src={user_icon} alt="" />
              <input type="text" placeholder="Enter Profile Name" />
            </div>

            <div className="input">
              <img src={phone_icon} alt="" />
              <input type="text" placeholder="Enter Mobile Number" />
            </div>
          </div>
        )}

        <div className="input">
          <img src={email_icon} alt="" />
          <input type="email" placeholder="Enter User Name" />
        </div>
        <div className="input">
          <img src={password_icon} alt="" />
          <input type="password" placeholder="Enter Password" />
        </div>
      </div>

      {action === "Sign Up" ? null : (
        <div className="forgot-password">
          Forgot Password? <span>Click Here!</span>
        </div>
      )}

      <div className="submit-container">
        <div className="submit" onClick={handleSubmit}>
          Submit
        </div>

        {action === "Login" ? (
          <div className="toggle-button" onClick={() => setAction("Sign Up")}>
            Sign Up
          </div>
        ) : (
          <div className="toggle-button" onClick={() => setAction("Login")}>
            Login
          </div>
        )}
      </div>
    </div>
  );
}

export default Login;
