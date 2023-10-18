using System.Numerics;

namespace TestSante.Classes
{
    public class BanqueDTO
    {
        public string idBanque { get; set; }
        public string nom { get; set; }
        public string adresse { get; set; }
        public string contact { get; set; }
        public string type { get; set; }
        public List<CompteDTO> compte { get; set; }

        public BanqueDTO(string idBanque, string nom, string adresse, string contact, string type, List<CompteDTO> compte) 
        {
        this.idBanque=idBanque;
        this.nom = nom;
        this.adresse = adresse;
        this.contact = contact;
        this.type = type;
        this.compte = compte;
    }
    public BanqueDTO(string idBanque, string nom, string adresse, string contact, string type) 
    {
        this.idBanque = idBanque;
        this.nom = nom;
        this.adresse = adresse;
        this.contact = contact;
        this.type = type;
    }
    public BanqueDTO()
    {

    }
}
}
