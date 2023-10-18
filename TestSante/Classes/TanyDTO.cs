namespace TestSante.Classes
{
    public class TanyDTO
    {
        public string numCadastre { get; set; }
        public string adresseTany { get; set; }
        public float superficie { get; set; }
        public String typeTany { get; set; }
        public Personne proprio { get; set; }

    public TanyDTO(string numCadastre, string adresseTany,float superficie, string typeTany, Personne proprio)
        {
        this.numCadastre=numCadastre;
        this.adresseTany=adresseTany;
        this.superficie=superficie;
        this.typeTany=typeTany;
        this.proprio=proprio;
    }
}
}
