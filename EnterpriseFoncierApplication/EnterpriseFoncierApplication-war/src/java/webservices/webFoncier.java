/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import com.google.gson.Gson;
import dto.BanqueDTO;
import dto.CompteDTO;
import dto.TanyDTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import sessionBean.BanqueRemote;
import sessionBean.TanyRemote;

/**
 * REST Web Service
 *
 * @author Antsa
 */
@Path("/generic")
public class webFoncier {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of webFoncier
     */
    public webFoncier() {
    }

    /**
     * Retrieves representation of an instance of webservices.webFoncier
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/{cin}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("cin")String cin) {
        String json="";
        try {
            Properties p = new Properties();
            p.setProperty("org.com.CORBA.ORBInitialHost", "localhost");
            p.setProperty("org.com.CORBA.ORBInitialPort", "3700");
            InitialContext ps=new InitialContext(p);
            BanqueRemote ta=(BanqueRemote)ps.lookup("java:global/EntrepriseBanqueApplication/EjbBanque/Banque!sessionBean.BanqueRemote");
            ArrayList<BanqueDTO> list=ta.getSolde(cin);
            Gson gson = new Gson();
            json= gson.toJson(list);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * PUT method for updating or creating an instance of webFoncier
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
