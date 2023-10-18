using Microsoft.Data.SqlClient;
using Microsoft.Extensions.Options;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using NuGet.Protocol.Plugins;
using System.Net;
using System.Threading.Channels;

namespace TestSante.Classes
{
    public class Personne
    {
        public string cin { get; set; }
        public string nom  { get; set; }
        public string prenom { get; set; }
        public string sexe { get;set; }
        public DateTime dateNaissance { get; set; }
        public string contact { get; set; }
        public string adresse { get; set; }

        public List<Allergie>? allergies { get; set; }

        public List<Maladie>? maladies { get; set; }

        public List<Antecedent>? antecedents { get; set; }
        public float poids { get; set; }    
        public float taille { get; set; }
        public void setdateNaissance(string dateNaissance)
        {
            DateTime daty = DateTime.Parse(dateNaissance);
            this.dateNaissance = daty;
        }

        public Personne(string cin,string prenom,string nom,string sexe,DateTime dateNaissance,string contact,string adresse)
        {
            this.cin=cin;
            this.prenom=prenom;
            this.nom=nom;
            this.sexe=sexe;
            if (this.sexe.Equals("1"))
            {
                this.sexe = "Masculin";
            }
            else
            {
                this.sexe = "Feminin";
            }
            this.dateNaissance=dateNaissance;
            this.contact=contact;
            this.adresse=adresse;
        }

        public Personne(string cin, string prenom, string nom, string sexe, string dateNaissance, string contact, string adresse)
        {
            this.cin = cin;
            this.prenom = prenom;
            this.nom = nom;
            this.sexe = sexe;
            this.setdateNaissance(dateNaissance);
            this.contact = contact;
            this.adresse = adresse;
        }

        public Personne()
        {

        }

        public static List<Personne> getAll()
        {
            using (SqlConnection connection = Connexion.getConnection())
            {
                string rqt = "select * from personne";
                SqlCommand commande = new SqlCommand(rqt, connection);

                connection.Open();
                SqlDataReader read = commande.ExecuteReader();
                List<Personne> lc = new List<Personne>();
                while (read.Read())
                {
                    Personne p = new Personne(read["cin"].ToString(), read["prenom"].ToString(), read["nom"].ToString(), read["sexe"].ToString(),read.GetDateTime(4),read["contact"].ToString(),read["adresse"].ToString());
                    lc.Add(p);
                }
                return lc;
            }
        }

        public static Personne getById(string idpersonne)
        {

            using (SqlConnection connection = Connexion.getConnection())
            {
                string query = "SELECT * FROM personne where cin=@id";
                SqlCommand command = new SqlCommand(query, connection);
                command.Parameters.AddWithValue("@id", idpersonne);
                connection.Open();
                SqlDataReader read = command.ExecuteReader();
                while (read.Read())
                {
                    Personne p = new Personne(read["cin"].ToString(), read["nom"].ToString(), read["prenom"].ToString(), read["sexe"].ToString(), read.GetDateTime(4), read["contact"].ToString(), read["adresse"].ToString());
                    return p;
                }
                return null;
            }

        }

        public List<Allergie> getAllergies()
        {
            List<Allergie> liste = new List<Allergie> ();
            using (SqlConnection connection = Connexion.getConnection())
            {
                string query = "SELECT idAllergie FROM allergique where cin=@id";
                SqlCommand command = new SqlCommand(query, connection);
                command.Parameters.AddWithValue("@id", this.cin);
                connection.Open();
                SqlDataReader read = command.ExecuteReader();
                while (read.Read())
                {
                    Allergie a = Allergie.getById(Convert.ToInt32(read["idAllergie"]));
                    liste.Add(a);
                }
            }
            return liste;
        }

        public List<Antecedent> getAntecedents()
        {
            List<Antecedent> liste=new List<Antecedent>();
            using (SqlConnection connection = Connexion.getConnection())
            {
                string query = "SELECT * FROM antecedent where cin=@id";
                SqlCommand command = new SqlCommand(query, connection);
                command.Parameters.AddWithValue("@id", this.cin);
                connection.Open();
                SqlDataReader read = command.ExecuteReader();
                while (read.Read())
                {
                    Antecedent a=new Antecedent(Hopital.getById(Convert.ToInt32(read["idHopital"])), read.GetDateTime(3), Docteur.getById(read["idDocteur"].ToString()), read["descriptions"].ToString(), read["organe"].ToString());
                    liste.Add(a);
                }
            }
            return liste;
        }

        public List<Maladie> getMaladies()
        {
            List<Maladie> maladies = new List<Maladie>();
            using (SqlConnection connection = Connexion.getConnection())
            {
                string query = "SELECT * FROM maladiePersonne where cin=@id";
                SqlCommand command = new SqlCommand(query, connection);
                command.Parameters.AddWithValue("@id", this.cin);
                connection.Open();
                SqlDataReader read = command.ExecuteReader();
                while (read.Read())
                {
                    Maladie a = Maladie.getById(Convert.ToInt32(read["idMaladie"]));
                    maladies.Add(a);
                }
            }
            return maladies;
        }

        public void setPoids()
        {
            using (SqlConnection connection = Connexion.getConnection())
            {
                string query = " select poids from poids where cin =@id and dateControl = (select max(dateControl) from poids where cin =@id);";
                SqlCommand command = new SqlCommand(query, connection);
                command.Parameters.AddWithValue("@id", this.cin);
                connection.Open();
                SqlDataReader read = command.ExecuteReader();
                while (read.Read())
                {
                    this.poids = Convert.ToSingle(read["poids"]);
                }
            }
        }
        public void setTaille()
        {
            float taille = 0;
            using (SqlConnection connection = Connexion.getConnection())
            {
                string query = " select taille from taille where cin =@id and dateControl = (select max(dateControl) from taille where cin =@id);";
                SqlCommand command = new SqlCommand(query, connection);
                command.Parameters.AddWithValue("@id", this.cin);
                connection.Open();
                SqlDataReader read = command.ExecuteReader();
                while (read.Read())
                {
                    this.taille = Convert.ToSingle(read["taille"]);
                }
            }

        }

        public static List<TanyDTO> GetTanyLova(string cin)
        {
            List<TanyDTO> liste = new List<TanyDTO>();
            string url = "http://localhost:8080/EntrepriseBanqueApplication-war/rest/generic/" + cin;
            WebRequest request = HttpWebRequest.Create(url);
            request.Method = "GET";
            using (WebResponse response = request.GetResponse())
            {
                using (Stream responseStream = response.GetResponseStream())
                {
                    using (StreamReader reader = new StreamReader(responseStream, System.Text.Encoding.UTF8))
                    {
                        string json = reader.ReadToEnd();
                        List<TanyDTO> tanyList = Newtonsoft.Json.JsonConvert.DeserializeObject<List<TanyDTO>>(json);
                        return tanyList;
                    }
                }
            }
            return liste;
        }
    }
}
