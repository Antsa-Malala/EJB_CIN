import React, { useState } from 'react';

function CinForm({ onCinSubmit }) {
  const [cin, setCin] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    onCinSubmit(cin);
  };

  return (
    <form onSubmit={handleSubmit}>
      <label>
        Entrez le numéro de CIN :
        <input
          type="text"
          value={cin}
          onChange={(e) => setCin(e.target.value)}
        />
      </label>
      <button type="submit">Soumettre</button>
    </form>
  );
}

export default CinForm;
