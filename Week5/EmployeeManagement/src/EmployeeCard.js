import React, { useContext } from "react";
import ThemeContext from "./ThemeContext";

function EmployeeCard({ employee }) {

  const theme = useContext(ThemeContext);

  return (

    <div
      style={{
        border: "1px solid gray",
        padding: "15px",
        margin: "10px"
      }}
    >

      <h2>{employee.name}</h2>

      <p>{employee.designation}</p>

      <button className={theme}>
        View Details
      </button>

    </div>

  );

}

export default EmployeeCard;