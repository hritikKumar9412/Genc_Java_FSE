import React from 'react';

function App() {
  const officeImage =
    'https://images.unsplash.com/photo-1497366754035-f200968a6e72?auto=format&fit=crop&w=900&q=80';

  const officeList = [
    { id: 1, name: 'Skyline Office', rent: 55000, address: 'Downtown, New York' },
    { id: 2, name: 'Harbor Space', rent: 65000, address: 'Sea View Avenue, Boston' },
    { id: 3, name: 'Green Park Hub', rent: 60000, address: 'Park Lane, Chicago' },
  ];

  return (
    <div style={{ fontFamily: 'Arial, sans-serif', backgroundColor: '#f8fafc', minHeight: '100vh', padding: '24px' }}>
      <h1 style={{ color: '#0f172a', textAlign: 'center' }}>Office Space Rental App</h1>
      <p style={{ textAlign: 'center', color: '#475569' }}>This app demonstrates JSX, attributes, expressions, and inline CSS in React.</p>

      <div style={{ display: 'flex', justifyContent: 'center', marginTop: '20px' }}>
        <img
          src={officeImage}
          alt="Office space"
          style={{ width: '420px', borderRadius: '12px', boxShadow: '0 8px 24px rgba(0,0,0,0.15)' }}
        />
      </div>

      <div style={{ marginTop: '24px', display: 'grid', gap: '16px', maxWidth: '900px', marginLeft: 'auto', marginRight: 'auto' }}>
        {officeList.map((office) => {
          const rentColor = office.rent < 60000 ? 'red' : 'green';

          return (
            <div key={office.id} style={{ backgroundColor: '#ffffff', padding: '16px 20px', borderRadius: '10px', boxShadow: '0 4px 12px rgba(0,0,0,0.08)' }}>
              <h2 style={{ marginBottom: '8px' }}>{office.name}</h2>
              <p><strong>Rent:</strong> <span style={{ color: rentColor, fontWeight: 'bold' }}>${office.rent}</span></p>
              <p><strong>Address:</strong> {office.address}</p>
            </div>
          );
        })}
      </div>
    </div>
  );
}

export default App;
