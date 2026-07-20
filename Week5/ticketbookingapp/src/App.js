import { useState } from 'react';
import './App.css';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const flightDetails = [
    { id: 1, flight: 'AI 101', route: 'Delhi -> Mumbai', time: '09:30 AM', fare: '₹4,500' },
    { id: 2, flight: '6E 202', route: 'Bengaluru -> Hyderabad', time: '12:15 PM', fare: '₹3,200' },
  ];

  let content;

  if (isLoggedIn) {
    content = (
      <div className="card">
        <h2>User Page</h2>
        <p>Welcome back! You can book tickets now.</p>
        <ul>
          {flightDetails.map((detail) => (
            <li key={detail.id}>
              <strong>{detail.flight}</strong> - {detail.route} at {detail.time} | {detail.fare}
            </li>
          ))}
        </ul>
        <button onClick={() => setIsLoggedIn(false)}>Logout</button>
      </div>
    );
  } else {
    content = (
      <div className="card">
        <h2>Guest Page</h2>
        <p>Please log in to book tickets.</p>
        <button onClick={() => setIsLoggedIn(true)}>Login</button>
      </div>
    );
  }

  return (
    <div className="app">
      <h1>Ticket Booking App</h1>
      <p className="intro">Conditional rendering shows different content for guests and logged-in users.</p>
      {content}
    </div>
  );
}

export default App;
