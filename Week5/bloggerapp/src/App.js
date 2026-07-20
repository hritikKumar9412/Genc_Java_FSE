import React, { useState } from 'react';
import './App.css';

const books = [
  { id: 1, title: 'React Basics', author: 'A. Kumar', available: true },
  { id: 2, title: 'Modern JavaScript', author: 'M. Rao', available: false },
  { id: 3, title: 'UI Design Patterns', author: 'R. Shah', available: true },
];

const blogs = [
  { id: 1, title: 'State in React', category: 'Frontend', readTime: '5 min' },
  { id: 2, title: 'Conditional Rendering', category: 'Learning', readTime: '3 min' },
  { id: 3, title: 'Keys and Lists', category: 'React', readTime: '4 min' },
];

const courses = [
  { id: 1, title: 'Mastering JSX', level: 'Beginner', duration: '3 weeks' },
  { id: 2, title: 'React Components Deep Dive', level: 'Intermediate', duration: '4 weeks' },
  { id: 3, title: 'Advanced Hooks', level: 'Advanced', duration: '5 weeks' },
];

function BookDetails({ books, showDetails }) {
  return (
    <section className="panel">
      <h3>Book Details</h3>
      <p>These cards show list rendering with map() and keys.</p>
      {showDetails ? (
        <ul className="item-list">
          {books.map((book) => (
            <li key={book.id}>
              <strong>{book.title}</strong> by {book.author}
              <span className={book.available ? 'badge available' : 'badge sold'}>
                {book.available ? 'Available' : 'Out of stock'}
              </span>
            </li>
          ))}
        </ul>
      ) : (
        <p>Use the toggle button to display the detailed book list.</p>
      )}
    </section>
  );
}

function BlogDetails({ blogs, showSummary }) {
  return (
    <section className="panel">
      <h3>Blog Details</h3>
      {showSummary && <p>This section uses logical && for conditional content.</p>}
      {blogs.map((blog) => (
        <article className="card" key={blog.id}>
          <h4>{blog.title}</h4>
          <p>{blog.category} • {blog.readTime}</p>
        </article>
      ))}
    </section>
  );
}

function CourseDetails({ courses, selectedCourse, onSelectCourse }) {
  return (
    <section className="panel">
      <h3>Course Details</h3>
      <div className="course-list">
        {courses.map((course) => (
          <button
            key={course.id}
            className={selectedCourse.id === course.id ? 'course-btn active' : 'course-btn'}
            onClick={() => onSelectCourse(course.id)}
          >
            {course.title}
          </button>
        ))}
      </div>
      {selectedCourse ? (
        <div className="course-card">
          <h4>{selectedCourse.title}</h4>
          <p>Level: {selectedCourse.level}</p>
          <p>Duration: {selectedCourse.duration}</p>
        </div>
      ) : null}
    </section>
  );
}

function App() {
  const [activeTab, setActiveTab] = useState('books');
  const [showBookDetails, setShowBookDetails] = useState(false);
  const [showBlogSummary, setShowBlogSummary] = useState(true);
  const [selectedCourseId, setSelectedCourseId] = useState(courses[0].id);

  const selectedCourse = courses.find((course) => course.id === selectedCourseId) || courses[0];

  const renderSection = () => {
    if (activeTab === 'blogs') {
      return <BlogDetails blogs={blogs} showSummary={showBlogSummary} />;
    }

    if (activeTab === 'courses') {
      return (
        <CourseDetails
          courses={courses}
          selectedCourse={selectedCourse}
          onSelectCourse={setSelectedCourseId}
        />
      );
    }

    return <BookDetails books={books} showDetails={showBookDetails} />;
  };

  return (
    <div className="app-shell">
      <header className="hero">
        <h1>Blogger App Lab</h1>
        <p>Explore conditional rendering, component composition, lists, and keys in React.</p>
      </header>

      <div className="controls">
        <button className={activeTab === 'books' ? 'tab active' : 'tab'} onClick={() => setActiveTab('books')}>
          Book Details
        </button>
        <button className={activeTab === 'blogs' ? 'tab active' : 'tab'} onClick={() => setActiveTab('blogs')}>
          Blog Details
        </button>
        <button className={activeTab === 'courses' ? 'tab active' : 'tab'} onClick={() => setActiveTab('courses')}>
          Course Details
        </button>
      </div>

      <div className="toggle-row">
        <button onClick={() => setShowBookDetails((value) => !value)}>
          {showBookDetails ? 'Hide' : 'Show'} book details
        </button>
        <button onClick={() => setShowBlogSummary((value) => !value)}>
          {showBlogSummary ? 'Hide' : 'Show'} blog summary
        </button>
      </div>

      {renderSection()}

      <section className="notes">
        <h3>Concepts covered</h3>
        <ul>
          <li>Ternary conditional rendering</li>
          <li>Logical && conditional rendering</li>
          <li>Render multiple components from one parent</li>
          <li>List rendering with map() and keys</li>
        </ul>
      </section>
    </div>
  );
}

export default App;
