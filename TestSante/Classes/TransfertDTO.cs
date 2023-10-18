namespace TestSante.Classes
{
    public class TransfertDTO
    {
        String idTransfert { get; set; }
        List<TransactionDTO> transactions { get; set; }
        DeviseDTO devise { get; set; }

        public TransfertDTO(String idTransfert, List<TransactionDTO> transactions, DeviseDTO devise)
        {
            this.idTransfert=idTransfert;
            this.transactions = transactions;
            this.devise = devise;
        }

        public TransfertDTO(String idTransfert, DeviseDTO devise)
        {
            this.idTransfert = idTransfert;
            this.devise = devise;
        }

        public TransfertDTO()
        {

        }
    }
}
