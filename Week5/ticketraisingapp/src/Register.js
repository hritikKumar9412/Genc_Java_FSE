import React, { useState } from "react";

function Register() {

  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const [errors, setErrors] = useState({});

  const validate = () => {

    let tempErrors = {};

    if (name.length < 5) {
      tempErrors.name = "Name must contain at least 5 characters";
    }

    if (!(email.includes("@") && email.includes("."))) {
      tempErrors.email = "Email should contain @ and .";
    }

    if (password.length < 8) {
      tempErrors.password = "Password must contain at least 8 characters";
    }

    setErrors(tempErrors);

    return Object.keys(tempErrors).length === 0;
  };

  const handleSubmit = (event) => {

    event.preventDefault();

    if (validate()) {
      alert("Registration Successful");
    }

  };

  return (

    <div className="container">

      <h2>Mail Registration Form</h2>

      <form onSubmit={handleSubmit}>

        <label>Name</label>

        <input
          type="text"
          value={name}
          onChange={(e) => setName(e.target.value)}
        />

        <span className="error">{errors.name}</span>

        <label>Email</label>

        <input
          type="email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />

        <span className="error">{errors.email}</span>

        <label>Password</label>

        <input
          type="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />

        <span className="error">{errors.password}</span>

        <button type="submit">
          Register
        </button>

      </form>

    </div>

  );

}

export default Register;