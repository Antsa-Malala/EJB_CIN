using Microsoft.Data.SqlClient;

namespace TestSante.Classes
{
    public class Docteur
    {
        public string idDocteur { get; set; }
        public string nom { get; set; }
        public string prenom { get; set; }
        public string titre { get; set; }
        public string contact { get; set; }


        public Docteur()
        {

        }
        public Docteur(string idDocteur,string nom,string prenom,string titre,string contact)
        {
            this.idDocteur=idDocteur;
            this.nom = nom;
            this.prenom = prenom;
            this.titre = titre; 
            this.contact = contact;
        }

        public static Docteur getById(string idDocteur)
        {
            Docteur a = new Docteur();
            using (SqlConnection connection = Connexion.getConnection())
            {
                string query = "SELECT * FROM docteur where iddocteur=@id";
                SqlCommand command = new SqlCommand(query, connection);
                command.Parameters.AddWithValue("@id", idDocteur);
                connection.Open();
                SqlDataReader read = command.ExecuteReader();
                while (read.Read())
                {
                    a = new Docteur(read["idDocteur"].ToString(), read["nom"].ToString(), read["prenom"].ToString(), read["titre"].ToString(), read["contact"].ToString());
                }
            }
            return a;
        }
    }
}
