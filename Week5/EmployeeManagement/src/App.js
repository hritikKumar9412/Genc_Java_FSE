import React, { useState } from "react";
import EmployeesList from "./EmployeesList";
import ThemeContext from "./ThemeContext";
import "./App.css";

function App() {

  const [theme] = useState("light");

  const employees = [

    {
      id: 1,
      name: "Hritik Kumar",
      designation: "Software Engineer"
    },

    {
      id: 2,
      name: "Rahul Sharma",
      designation: "UI Developer"
    },

    {
      id: 3,
      name: "Ankit Singh",
      designation: "Tester"
    }

  ];

  return (

    <ThemeContext.Provider value={theme}>

      <div>

        <h1>Employee Management System</h1>

        <EmployeesList employees={employees} />

      </div>

    </ThemeContext.Provider>

  );

}

export default App;