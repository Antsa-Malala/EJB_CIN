namespace TestSante.Classes
{
    public class Antecedent
    {
        public Hopital hopital { get; set; }
        public DateTime dateOperation { get; set; }
        public Docteur docteur { get; set; }
        public string description { get; set; }
        public string organe { get; set; }

        public Antecedent() { }

        public Antecedent(Hopital hopital,DateTime daty,Docteur doko,string description,string organe)
        {
            this.hopital = hopital;
            this.dateOperation = daty;
            this.docteur = doko;
            this.description = description;
            this.organe = organe;
        }
    }
}
