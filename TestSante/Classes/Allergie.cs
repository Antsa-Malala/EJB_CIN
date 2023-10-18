using Microsoft.Data.SqlClient;

namespace TestSante.Classes
{
    public class Allergie
    {
        public int idAllergie { get; set; }

        public string allergie { get;set; }

        public Allergie()
        {
            
        }

        public Allergie(int id,string nom)
        {
            this.idAllergie=id;
            this.allergie = nom;
        }
        public static Allergie getById(int idAllergie)
        {
            Allergie a = new Allergie();
            using (SqlConnection connection = Connexion.getConnection())
            {
                string query = "SELECT * FROM allergie where idAllergie=@id";
                SqlCommand command = new SqlCommand(query, connection);
                command.Parameters.AddWithValue("@id", idAllergie);
                connection.Open();
                SqlDataReader read = command.ExecuteReader();
                while (read.Read())
                {
                    a = new Allergie(Convert.ToInt32(read["idAllergie"]), read["allergie"].ToString());
                    Console.WriteLine("gaha");
                }
            }
            return a;
        }
    }
}
