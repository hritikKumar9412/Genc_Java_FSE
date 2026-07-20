import { useState } from 'react';
import './App.css';

function CurrencyConvertor() {
  const [inr, setInr] = useState('');
  const [result, setResult] = useState('');

  const handleSubmit = (event) => {
    event.preventDefault();
    const amount = Number(inr);

    if (!Number.isNaN(amount) && amount > 0) {
      const euro = (amount / 90).toFixed(2);
      setResult(`${amount} INR = ${euro} EUR`);
    } else {
      setResult('Please enter a valid positive amount');
    }
  };

  return (
    <div className="card">
      <h3>CurrencyConvertor</h3>
      <p>Convert Indian Rupees to Euro.</p>
      <input
        type="number"
        value={inr}
        onChange={(event) => setInr(event.target.value)}
        placeholder="Enter INR"
      />
      <button type="button" onClick={handleSubmit}>
        Convert
      </button>
      <p className="result">{result}</p>
    </div>
  );
}

function App() {
  const [count, setCount] = useState(0);
  const [message, setMessage] = useState('No events triggered yet.');
  const [welcomeMessage, setWelcomeMessage] = useState('Click the button to welcome.');
  const [syntheticMessage, setSyntheticMessage] = useState('Synthetic event waiting...');

  const increaseCounter = () => {
    setCount((prev) => prev + 1);
    setMessage('Hello! Count increased.');
  };

  const decreaseCounter = () => {
    setCount((prev) => prev - 1);
    setMessage('Goodbye! Count decreased.');
  };

  const handleWelcome = (name) => {
    setWelcomeMessage(`Welcome ${name}!`);
  };

  const handleOnPress = (event) => {
    event.preventDefault();
    setSyntheticMessage('I was clicked');
  };

  return (
    <div className="app">
      <h1>React Event Examples</h1>
      <p className="intro">
        This app demonstrates React events, event handlers, synthetic events, and React event naming conventions.
      </p>

      <section className="concepts">
        <div className="card">
          <h2>React events</h2>
          <p>React events are handled with camelCase attributes like onClick and onChange.</p>
        </div>
        <div className="card">
          <h2>Event handlers</h2>
          <p>Event handlers are functions that respond to user actions and update state or trigger logic.</p>
        </div>
        <div className="card">
          <h2>Synthetic event</h2>
          <p>A synthetic event is React&apos;s wrapped version of the browser event, giving consistent behaviour.</p>
        </div>
        <div className="card">
          <h2>Naming convention</h2>
          <p>React uses camelCase names such as onClick, onMouseOver, and onSubmit.</p>
        </div>
      </section>

      <section className="examples">
        <div className="card">
          <h2>Counter example</h2>
          <p>
            Count: <strong>{count}</strong>
          </p>
          <p>{message}</p>
          <div className="button-row">
            <button onClick={increaseCounter}>Increase</button>
            <button onClick={decreaseCounter}>Decrease</button>
          </div>
        </div>

        <div className="card">
          <h2>Welcome example</h2>
          <p>{welcomeMessage}</p>
          <button onClick={() => handleWelcome('student')}>Say Welcome</button>
        </div>

        <div className="card">
          <h2>Synthetic event demo</h2>
          <p>{syntheticMessage}</p>
          <button onClick={handleOnPress}>OnPress</button>
        </div>

        <CurrencyConvertor />
      </section>
    </div>
  );
}

export default App;
