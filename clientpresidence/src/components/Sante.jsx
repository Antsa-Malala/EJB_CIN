import React, { useState, useEffect } from 'react';
import { format } from 'date-fns';
import "./Sante.css";

function Sante(props) {
  const [cin, setCin] = useState('');
  const [personne, setPersonne] = useState(null); 
  const [banque, setBanque] = useState([]); 
  const [tany, setTany] = useState([]); 

  useEffect(() => {
    if (cin && cin.length>=10) {
    const url = `http://localhost:62560/api/Personnes/${cin}`;
    fetch(url)
      .then(response => {
        if (!response.ok) {
          throw new Error('La requête n\'a pas abouti.');
        }
        return response.json();
      })
      .then(data => {
        setPersonne(data); 
      })
      .catch(error => {
        console.error('Une erreur s\'est produite : ' + error);
      });

    const url1 = `http://localhost:62560/api/Personnes/foncier/${cin}`;
    fetch(url1)
      .then(response => {
        if (!response.ok) {
          throw new Error('La requête n\'a pas abouti.');
        }
        return response.json();
      })
      .then(data => {
        setTany(data); 
      })
      .catch(error => {
        console.error('Une erreur s\'est produite : ' + error);
      });

      const url2 = `http://localhost:62560/api/Personnes/banque/${cin}`;
    fetch(url2)
      .then(response => {
        if (!response.ok) {
          throw new Error('La requête n\'a pas abouti.');
        }
        return response.json();
      })
      .then(data => {
        setBanque(data); 
      })
      .catch(error => {
        console.error('Une erreur s\'est produite : ' + error);
      });
    }
  }, [cin]); 

  const handleCinChange = (e) => {
    setCin(e.target.value);
  };

  return (
    <div>
      <form>
        <label>
          Entrez le numéro d'identification (CIN) :
          <input type="text" value={cin} onChange={handleCinChange} />
        </label>
      </form>
      {personne ? (
        <div>
          <div className="person-info">
              <h3 className="title">{personne.cin}</h3>
              <div className="info-row">
                  <div className="info-label">Nom:</div>
                  <div className="info-value">{personne.nom}</div>
              </div>
              <div className="info-row">
                  <div className="info-label">Prenom:</div>
                  <div className="info-value">{personne.prenom}</div>
              </div>
              <div className="info-row">
                  <div className="info-label">Sexe:</div>
                  <div className="info-value">{personne.sexe}</div>
              </div>
              <div className="info-row">
                  <div className="info-label">Date de naissance:</div>
                  <div className="info-value">{format(new Date(personne.dateNaissance), 'dd MMMM yyyy')}</div>
              </div>
              <div className="info-row">
                  <div className="info-label">Contact:</div>
                  <div className="info-value">{personne.contact}</div>
              </div>
              <div className="info-row">
                  <div className="info-label">Adresse:</div>
                  <div className="info-value">{personne.adresse}</div>
              </div>
              <div className="info-row">
                  <div className="info-label">Poids:</div>
                  <div className="info-value">{personne.poids} kg</div>
              </div>
              <div className="info-row">
                  <div className="info-label">Taille:</div>
                  <div className="info-value">{personne.taille} cm</div>
              </div>
          </div>

            <div className="allergies-list">
                <h5 className="list-header">Allergies:</h5>
                {personne.allergies.map((allergie, index) => (
                    <div className="allergy-item">
                        <h3 className="allergy-name">{allergie.allergie}</h3>
                    </div>
                ))}
            </div>

            <div className="maladies-list">
                <h5 className="list-header">Maladies:</h5>
                <table>
                    <thead>
                        <tr>
                            <th>Maladie</th>
                            <th>Date de Découverte</th>
                            <th>Héréditaire</th>
                        </tr>
                    </thead>
                    <tbody>
                      {personne.maladies.map((maladie, index) => (
                            <tr className="maladie-row">
                                <td>{maladie.maladie}</td>
                                <td>{format(new Date(maladie.decouverte), 'dd/MM/yyyy')}</td>
                                <td>{maladie.hereditaire}</td>
                            </tr>
                        ))
                      }
                    </tbody>
                </table>
            </div>

            <div className="antecedents-list">
                <h5 className="list-header">Antecedent chirurgicales:</h5>
                <table>
                    <thead>
                        <tr>
                            <th>Description et Organe</th>
                            <th>Hopital</th>
                            <th>Date de l'Opération</th>
                            <th>Docteur</th>
                        </tr>
                    </thead>
                    <tbody>
                    {personne.antecedents.map((antecedent, index) => (
                            <tr className="antecedent-row">
                                <td>{antecedent.description} : {antecedent.organe}</td>
                                <td>{antecedent.hopital.nom}</td>
                                <td>{format(new Date(antecedent.dateOperation), 'dd/MM/yyyy à HH:mm:ss')}</td>
                                <td>{antecedent.docteur.titre} : {antecedent.docteur.nom} {antecedent.docteur.prenom}</td>
                            </tr>
                        ))
                    }
                    </tbody>
                </table>
            </div>

        </div>
      ) : (
        <p></p>
      )}

      {banque ? (
        <div className="bank-accounts">
            <h3 className="list-header">Vos comptes bancaires:</h3>
            {banque.map((banky, index) => (
                <div className="bank-card">
                    <h4 className="bank-info">{banky.nom} : {banky.type}</h4>
                    {banky.compte.map((kaonty, index) => (
                        <div className="account-card">
                            <h5 className="account-title">{kaonty.numCompte} : Ar {kaonty.solde}</h5>
                            <p className="account-info">{kaonty.typeCompte}</p>
                            <p className="account-info">Date de création : {kaonty.dateCreation}</p>
                            <table className="transaction-table">
                                <thead>
                                    <tr>
                                        <th>Type de Transaction</th>
                                        <th>Montant</th>
                                        <th>Date</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {kaonty.transactions.map((transact, index) => (
                                    
                                        <tr>
                                            <td>{transact.typeTransaction}</td>
                                            <td>{transact.montant}</td>
                                            <td>{transact.daty}</td>
                                        </tr>
                                    ))
                                  }
                                </tbody>
                            </table>
                        </div>
                    ))
                  }
                </div>
            ))
          }
        </div>
      ) : (
        <p></p>
      )
      }

      { tany ? (
        <div className="property-list">
            <h3 className="list-header">Vos propriétés:</h3>
            <div className="horizontal-list">
              {tany.map((tan, index) => (
                    <div className="property-card">
                        <h4 className="property-title">{tan.numCadastre}</h4>
                        <p className="property-info">{tan.adresseTany}</p>
                        <p className="property-info">{tan.superficie} m²</p>
                        <p className="property-info">Type : {tan.typeTany}</p>
                        <p className="property-info">Acquisition : {tan.dateAcquisition} </p>
                    </div>
                ))
              }
            </div>
        </div>
    
      ) : (
        <p></p>
      )

      }
    </div>
  );
}

export default Sante;
