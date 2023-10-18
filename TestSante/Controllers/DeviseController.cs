using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using System;
using TestSante.Classes;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace TestSante.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class DeviseController : ControllerBase
    {
        // GET: api/<DeviseController>
        [HttpGet("{daty}")]
        public List<DeviseDTO> Get(String? daty)
        {
            if(daty!=null)
            {
                DateTime dateTime = DateTime.Parse(daty);
                return DeviseDTO.getAll(dateTime);
            }
            else
            {
                return DeviseDTO.getAll(null);
            }

        }
        [HttpGet("{id}/{daty}")]
        public DeviseDTO GetById(int id, String? daty)
        {
            if (daty != null)
            {
                DateTime dateTime = DateTime.Parse(daty);
                return DeviseDTO.getById(id,dateTime);
            }
            else
            {
                return DeviseDTO.getById(id,null);
            }

        }

        [HttpGet("Vente/{daty}")]
        public List<DeviseDTO> GetVente(String? daty)
        {
            if (daty != null)
            {
                DateTime dateTime = DateTime.Parse(daty);
                return DeviseDTO.getAllVente(dateTime);
            }
            else
            {
                return DeviseDTO.getAllVente(null);
            }

        }

        [HttpGet("Vente/{id}/{daty}")]
        public DeviseDTO GetByIdVente(int id, String? daty)
        {
            if (daty != null)
            {
                DateTime dateTime = DateTime.Parse(daty);
                return DeviseDTO.getByIdVente(id, dateTime);
            }
            else
            {
                return DeviseDTO.getByIdVente(id, null);
            }

        }
    }
}
