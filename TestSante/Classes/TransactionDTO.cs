using static System.Runtime.InteropServices.JavaScript.JSType;


namespace TestSante.Classes
{
    public class TransactionDTO
    {
        public string idTransaction { get; set; }
        public string typeTransaction { get; set; }
        public float montant { get; set; }
        public string daty { get; set; }

        public TransactionDTO(string idTransaction, string typeTransaction, float montant, string daty)
        {
            this.idTransaction=idTransaction;
            this.typeTransaction=typeTransaction;
            this.montant=montant;
            this.daty=daty;
        }
    }
}
