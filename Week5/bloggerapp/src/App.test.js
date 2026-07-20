import { fireEvent, render, screen } from '@testing-library/react';
import App from './App';

test('renders the three sections and toggles conditional content', () => {
  render(<App />);

  expect(screen.getByRole('heading', { name: /blogger app lab/i })).toBeInTheDocument();

  fireEvent.click(screen.getByRole('button', { name: /show book details/i }));
  expect(screen.getByText(/react basics/i)).toBeInTheDocument();

  fireEvent.click(screen.getByRole('button', { name: /blog details/i }));
  expect(screen.getByText(/state in react/i)).toBeInTheDocument();

  fireEvent.click(screen.getByRole('button', { name: /course details/i }));
  expect(screen.getByText(/mastering jsx/i)).toBeInTheDocument();
});
