using Microsoft.Data.SqlClient;

namespace TestSante.Classes
{
    public class Connexion
    {
        public static SqlConnection getConnection()
        {
            string connectionString = "Server=(localdb)\\MSSQLLocalDB;Database=sante;Trusted_Connection=True;";
            SqlConnection connection = new SqlConnection(connectionString);
            return connection;
        }
    }
}
