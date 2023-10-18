using Microsoft.AspNetCore.Mvc;
using Microsoft.Data.SqlClient;
using TestSante.Classes;
using System.Web.Http.Cors;
using Newtonsoft.Json;
using System.Net;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace TestSante.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    [EnableCors(origins: "*", headers: "*", methods: "*")]
    public class PersonnesController : ControllerBase
    {
        // GET: api/<PersonnesController>
        [HttpGet]
        public List<Personne> Get()
        {
            List<Personne> liste = Personne.getAll();
            return liste;
        }

        // GET api/<PersonnesController>/5
        [HttpGet("{id}")]
        public Personne Get(string id)
        {
            Personne one = Personne.getById(id);
            one.setPoids();
            one.setTaille();
            one.allergies = one.getAllergies();
            one.maladies = one.getMaladies();
            one.antecedents = one.getAntecedents();
            return one;
        }

        [HttpGet("info/{id}")]
        public Personne GetInfo(string id)
        {
            Personne one = Personne.getById(id);
            if(one!=null)
            {
                one.setPoids();
                one.setTaille();
            }
            return one;
        }
        [HttpGet("banque/{cin}")]
        public List<BanqueDTO> GetBanque(string cin)
        {
            List<BanqueDTO> list = new List<BanqueDTO>();
            string url2 = "http://localhost:8080/EnterpriseFoncierApplication-war/rest/generic/" + cin;
            WebRequest request2 = HttpWebRequest.Create(url2);
            request2.Method = "GET";
            using (WebResponse response = request2.GetResponse())
            {
                using (Stream responseStream = response.GetResponseStream())
                {
                    using (StreamReader reader = new StreamReader(responseStream, System.Text.Encoding.UTF8))
                    {
                        string json = reader.ReadToEnd();
                        list = JsonConvert.DeserializeObject<List<BanqueDTO>>(json);
                    }
                }
            }
            return list;
        }
        [HttpGet("foncier/{cin}")]
        public List<TanyDTO> Getfoncier(string cin)
        {
            List<TanyDTO> liste = new List<TanyDTO>();
            string url1 = "http://localhost:8080/EntrepriseBanqueApplication-war/rest/generic/" + cin;
            WebRequest request1 = HttpWebRequest.Create(url1);
            request1.Method = "GET";
            using (WebResponse response = request1.GetResponse())
            {
                using (Stream responseStream = response.GetResponseStream())
                {
                    using (StreamReader reader = new StreamReader(responseStream, System.Text.Encoding.UTF8))
                    {
                        string json = reader.ReadToEnd();
                        liste = JsonConvert.DeserializeObject<List<TanyDTO>>(json);
                    }
                }
            }
            return liste;
        }
    }
}
