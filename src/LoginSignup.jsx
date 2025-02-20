import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import user_icon from "./assets/profile_name.png";
import phone_icon from "./assets/phone.svg";
import email_icon from "./assets/user_name.svg";
import password_icon from "./assets/password.svg";
import "./LoginSignup.css";

function Login() {
  const [action, setAction] = useState("Sign Up");
  const navigate = useNavigate();

  // State for form inputs
  const [formData, setFormData] = useState({
    profileName: "",
    mobileNumber: "",
    username: "",
    password: "",
  });

  // Handle input change
  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  // Handle form submission
  const handleSubmit = () => {
    const { username, password, profileName, mobileNumber } = formData;
  
    const requestData =
      action === "Login"
        ? { username, password }
        : { profileName, mobileNumber, username, password };
  
    const url =
      action === "Login"
        ? "http://localhost:8080/users/login"
        : "http://localhost:8080/users/register";
  
    fetch(url, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(requestData),
    })
      .then((response) => {
        // Check response status
        if (!response.ok) {
          throw new Error(`HTTP error! Status: ${response.status}`);
        }
        // Handle both JSON and plain text responses
        const contentType = response.headers.get("content-type");
        if (contentType && contentType.includes("application/json")) {
          return response.json();
        } else {
          return response.text();
        }
      })
      .then((data) => {
        console.log("Response:", data);
        navigate("/home"); // Navigate on success
      })
      .catch((error) => {
        console.error("Error:", error);
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
              <input
                type="text"
                name="profileName"
                placeholder="Enter Profile Name"
                value={formData.profileName}
                onChange={handleChange}
              />
            </div>

            <div className="input">
              <img src={phone_icon} alt="" />
              <input
                type="text"
                name="mobileNumber"
                placeholder="Enter Mobile Number"
                value={formData.mobileNumber}
                onChange={handleChange}
              />
            </div>
          </div>
        )}

        <div className="input">
          <img src={email_icon} alt="" />
          <input
            type="email"
            name="username"
            placeholder="Enter User Name"
            value={formData.username}
            onChange={handleChange}
          />
        </div>

        <div className="input">
          <img src={password_icon} alt="" />
          <input
            type="password"
            name="password"
            placeholder="Enter Password"
            value={formData.password}
            onChange={handleChange}
          />
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
