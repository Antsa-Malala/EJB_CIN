using Microsoft.Data.SqlClient;

namespace TestSante.Classes
{
    public class Maladie
    {
        public int idMaladie   {get; set;}
        public string maladie { get; set; }
        public DateTime decouverte { get; set; }
        public string hereditaire { get; set; }

        public Maladie()
        {

        }
        public Maladie(int idMaladie,string maladie,DateTime decouverte,string hereditaire)
        {
            this.idMaladie=idMaladie;
            this.maladie = maladie;
            this.decouverte = decouverte;
            this.hereditaire = hereditaire;
            if(this.hereditaire.Equals("1"))
            {
                this.hereditaire = "Oui";
            }
            else
            {
                this.hereditaire = "Non";
            }
        }

        public static Maladie getById(int idMaladie)
        {
            Maladie a = new Maladie();
            using (SqlConnection connection = Connexion.getConnection())
            {
                string query = "SELECT maladiePersonne.*,maladie.nom,maladie.hereditaire FROM maladiePersonne join maladie on maladie.idMaladie=maladiePersonne.idMaladie where maladie.idmaladie=@id";
                SqlCommand command = new SqlCommand(query, connection);
                command.Parameters.AddWithValue("@id", idMaladie);
                connection.Open();
                SqlDataReader read = command.ExecuteReader();
                while (read.Read())
                {
                    a = new Maladie(Convert.ToInt32(read["idMaladie"]),read["nom"].ToString(), read.GetDateTime(2), read["hereditaire"].ToString());
                }
            }
            return a;
        }
    }
}
