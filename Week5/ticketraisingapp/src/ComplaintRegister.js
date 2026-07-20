import React, { useState } from "react";

function ComplaintRegister() {

  const [employeeName, setEmployeeName] = useState("");
  const [complaint, setComplaint] = useState("");

  const handleSubmit = (event) => {
    event.preventDefault();

    const referenceNo = Math.floor(100000 + Math.random() * 900000);

    alert(
      `Thanks ${employeeName}.\n\nYour complaint has been submitted successfully.\n\nReference Number: ${referenceNo}`
    );

    setEmployeeName("");
    setComplaint("");
  };

  return (
    <div className="container">

      <h2>Ticket Raising Application</h2>

      <form onSubmit={handleSubmit}>

        <label>Employee Name</label>

        <input
          type="text"
          placeholder="Enter Employee Name"
          value={employeeName}
          onChange={(e) => setEmployeeName(e.target.value)}
          required
        />

        <label>Complaint</label>

        <textarea
          rows="5"
          placeholder="Enter Complaint"
          value={complaint}
          onChange={(e) => setComplaint(e.target.value)}
          required
        ></textarea>

        <button type="submit">
          Submit Complaint
        </button>

      </form>

    </div>
  );
}

export default ComplaintRegister;