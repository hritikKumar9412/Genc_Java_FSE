import { fireEvent, render, screen } from '@testing-library/react';
import App from './App';

test('shows guest view first and switches to the user view after login', () => {
  render(<App />);

  expect(screen.getByText(/Guest Page/i)).toBeInTheDocument();
  expect(screen.getByText(/Please log in to book tickets/i)).toBeInTheDocument();

  fireEvent.click(screen.getByRole('button', { name: /login/i }));

  expect(screen.getByText(/User Page/i)).toBeInTheDocument();
  expect(screen.getByText(/Welcome back! You can book tickets now./i)).toBeInTheDocument();

  fireEvent.click(screen.getByRole('button', { name: /logout/i }));

  expect(screen.getByText(/Guest Page/i)).toBeInTheDocument();
});
