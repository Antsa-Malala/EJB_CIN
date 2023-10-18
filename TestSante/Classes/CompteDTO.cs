using Newtonsoft.Json;
using static System.Runtime.InteropServices.JavaScript.JSType;


namespace TestSante.Classes
{
    public class CompteDTO
    {
        public string numCompte { get; set; }
        public BanqueDTO banque { get; set; }
        public string typeCompte { get; set; }

        public string dateCreation { get; set; }
        public List<TransactionDTO> transactions { get; set; }
        public float solde { get; set; }

        public CompteDTO(string numCompte, BanqueDTO banque, string typeCompte, string dateCreation, List<TransactionDTO> tra, float solde)
        {
            this.numCompte = numCompte;
            this.banque = banque;
            this.typeCompte = typeCompte;
            this.dateCreation = dateCreation;
            this.transactions = tra;
            this.solde = solde;
        }
        public CompteDTO()
        {

        }
    }
}
