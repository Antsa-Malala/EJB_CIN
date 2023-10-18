using Microsoft.Data.SqlClient;

namespace TestSante.Classes
{
    public class Hopital
    {
        public int idHopital { get; set; }
        public string nom { get; set; }
        public string adresse { get; set; }

        public Hopital() { }

        public Hopital(int idHopital,string nom,string adresse)
        {
            this.idHopital = idHopital;
            this.nom = nom;
            this.adresse = adresse;
        }

        public static Hopital getById(int idHopital)
        {
            Hopital a = new Hopital();
            using (SqlConnection connection = Connexion.getConnection())
            {
                string query = "SELECT * FROM hopital where idhopital=@id";
                SqlCommand command = new SqlCommand(query, connection);
                command.Parameters.AddWithValue("@id", idHopital);
                connection.Open();
                SqlDataReader read = command.ExecuteReader();
                while (read.Read())
                {
                    a = new Hopital(Convert.ToInt32(read["idHopital"]), read["nom"].ToString(), read["adresse"].ToString());
                    Console.WriteLine("gaha");
                }
            }
            return a;
        }
    }
}
