using Microsoft.Data.SqlClient;

namespace TestSante.Classes
{
    public class DeviseDTO
    {
        public int iddevise { get; set; }
        public string nom { get; set; }
        public float valeur { get; set; }
        public DateTime? dateDevise { get; set; }   

        public DeviseDTO() { }

        public DeviseDTO(int iddevise, string nom, DateTime? dateDevise)
        {
            this.iddevise = iddevise;
            this.nom = nom;
            if(dateDevise!=null)
            {
                this.dateDevise = dateDevise;
                this.valeur=this.getValeur(dateDevise);
            }
            else
            {
                this.valeur=this.getValeur(null);
                this.dateDevise = DateTime.Now;
            }
        }

        public DeviseDTO(int iddevise, string nom, DateTime? dateDevise,String vente)
        {
            this.iddevise = iddevise;
            this.nom = nom;
            if (dateDevise != null)
            {
                this.dateDevise = dateDevise;
                this.valeur = this.getValeurVente(dateDevise);
            }
            else
            {
                this.valeur = this.getValeurVente(null);
                this.dateDevise = DateTime.Now;
            }
        }

        public DeviseDTO(int iddevise,string nom)
        {
            this.iddevise = iddevise;
            this.nom = nom;
        }

        public DeviseDTO(int iddevise)
        {
            this.iddevise = iddevise;
        }

        public float getValeur(DateTime? dateDev)
        {
            float valeur = 1;
            using (SqlConnection connection = Connexion.getConnection())
            {
                string query = "";
                if (dateDev != null)
                {
                    query = "SELECT TOP 1 valeur FROM cout where iddevise=@id and datedevise <= @date ORDER BY datedevise DESC";
                    SqlCommand command = new SqlCommand(query, connection);
                    command.Parameters.AddWithValue("@id", this.iddevise);
                    command.Parameters.AddWithValue("@date", dateDev.Value.Date);
                    connection.Open();
                    SqlDataReader read = command.ExecuteReader();
                    while (read.Read())
                    {
                    Console.WriteLine("haha" + this.iddevise);
                        valeur = Convert.ToSingle(read["valeur"]);
                    }
                }
                else
                {
                    query = "SELECT TOP 1 valeur FROM cout where iddevise=@id ORDER BY datedevise DESC";
                    SqlCommand command = new SqlCommand(query, connection);
                    command.Parameters.AddWithValue("@id", this.iddevise);
                    connection.Open();
                    SqlDataReader read = command.ExecuteReader();
                    while (read.Read())
                    {
                        valeur = Convert.ToSingle(read["valeur"]);
                    }
                }
            }
            return valeur;
        }

        public float getValeurVente(DateTime? dateDev)
        {
            float valeur = 1;
            using (SqlConnection connection = Connexion.getConnection())
            {
                string query = "";
                if (dateDev != null)
                {
                    query = "SELECT valeur FROM coutDeviseVente where iddevise=@id ORDER BY datedevise DESC";
                    SqlCommand command = new SqlCommand(query, connection);
                    command.Parameters.AddWithValue("@id", this.iddevise);
                    command.Parameters.AddWithValue("@date", dateDev.Value.Date);
                    connection.Open();
                    SqlDataReader read = command.ExecuteReader();
                    while (read.Read())
                    {
                        Console.WriteLine("haha" + this.iddevise);
                        valeur = Convert.ToSingle(read["valeur"]);
                        break;
                    }
                }
                else
                {
                    query = "SELECT valeur FROM coutDeviseVente where iddevise=@id ORDER BY datedevise DESC";
                    SqlCommand command = new SqlCommand(query, connection);
                    command.Parameters.AddWithValue("@id", this.iddevise);
                    connection.Open();
                    SqlDataReader read = command.ExecuteReader();
                    while (read.Read())
                    {
                        valeur = Convert.ToSingle(read["valeur"]);
                        break;
                    }
                }
            }
            return valeur;
        }

        public static List<DeviseDTO> getAll(DateTime? date)
        {
            List<DeviseDTO> a = new List<DeviseDTO>();
            using (SqlConnection connection = Connexion.getConnection())
            {
                string query = "SELECT * FROM devise";
                SqlCommand command = new SqlCommand(query, connection);
                connection.Open();
                SqlDataReader read = command.ExecuteReader();
                while (read.Read())
                {
                    DeviseDTO d=new DeviseDTO(Convert.ToInt32(read["idDevise"]), read["nomDevise"].ToString(),date);
                    a.Add(d);
                }
            }
            return a;
        }

        public static List<DeviseDTO> getAllVente(DateTime? date)
        {
            List<DeviseDTO> a = new List<DeviseDTO>();
            using (SqlConnection connection = Connexion.getConnection())
            {
                string query = "SELECT * FROM deviseVente";
                SqlCommand command = new SqlCommand(query, connection);
                connection.Open();
                SqlDataReader read = command.ExecuteReader();
                while (read.Read())
                {
                    DeviseDTO d = new DeviseDTO(Convert.ToInt32(read["idDevise"]), read["nomDevise"].ToString(), date,"deu");
                    a.Add(d);
                }
            }
            return a;
        }
        public static DeviseDTO getById(int id,DateTime? date)
        {
            DeviseDTO a = new DeviseDTO();
            using (SqlConnection connection = Connexion.getConnection())
            {
                string query = "SELECT * FROM devise where iddevise=@id";
                SqlCommand command = new SqlCommand(query, connection);
                command.Parameters.AddWithValue("@id",id);
                connection.Open();
                SqlDataReader read = command.ExecuteReader();
                while (read.Read())
                {
                   a= new DeviseDTO(Convert.ToInt32(read["idDevise"]), read["nomDevise"].ToString(), date);
                }
            }
            return a;
        }

        public static DeviseDTO getByIdVente(int id, DateTime? date)
        {
            DeviseDTO a = new DeviseDTO();
            using (SqlConnection connection = Connexion.getConnection())
            {
                string query = "SELECT * FROM deviseVente where iddevise=@id";
                SqlCommand command = new SqlCommand(query, connection);
                command.Parameters.AddWithValue("@id", id);
                connection.Open();
                SqlDataReader read = command.ExecuteReader();
                while (read.Read())
                {
                    a = new DeviseDTO(Convert.ToInt32(read["idDevise"]), read["nomDevise"].ToString(), date,"vhik");
                }
            }
            return a;
        }
    }
}
