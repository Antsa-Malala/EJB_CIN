/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.TanyDTO;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import static java.lang.System.out;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.ws.rs.PathParam;
import sessionBean.TanyRemote;

/**
 * REST Web Service
 *
 * @author Antsa
 */
@Path("/generic")
public class webBanque {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of webBanque
     */
    public webBanque() {
    }

    /**
     * Retrieves representation of an instance of webservices.webBanque
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
            TanyRemote ta=(TanyRemote)ps.lookup("java:global/EnterpriseFoncierApplication/EjbFoncier/Tany!sessionBean.TanyRemote");
            ArrayList<TanyDTO> list=(ArrayList<TanyDTO>)ta.liste_tany(cin);
            System.out.println("fbje");
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
     * PUT method for updating or creating an instance of webBanque
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
