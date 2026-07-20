import { fireEvent, render, screen } from '@testing-library/react';
import App from './App';

test('renders the heading and updates the counter on increase', () => {
  render(<App />);

  expect(screen.getByText(/React Event Examples/i)).toBeInTheDocument();

  fireEvent.click(screen.getByRole('button', { name: /increase/i }));

  expect(screen.getByText(/Count:/i)).toHaveTextContent('Count: 1');
  expect(screen.getByText(/Hello! Count increased./i)).toBeInTheDocument();
});

test('shows welcome and synthetic event messages', () => {
  render(<App />);

  fireEvent.click(screen.getByRole('button', { name: /say welcome/i }));
  expect(screen.getByText(/Welcome student!/i)).toBeInTheDocument();

  fireEvent.click(screen.getByRole('button', { name: /onpress/i }));
  expect(screen.getByText(/I was clicked/i)).toBeInTheDocument();
});
