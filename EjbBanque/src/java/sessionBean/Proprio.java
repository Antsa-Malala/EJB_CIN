/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.ProprioDTO;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.sql.Connection;
import javax.ejb.Stateless;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 *
 * @author Antsa
 */
@Stateless
public class Proprio implements ProprioRemote, ProprioLocal {
    @Override
    public ProprioDTO getById(Connection con,String cin) throws Exception
    {
        String content="";
        try {
            TrustManager[] trustAllCertificates = new TrustManager[]{
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                    public void checkClientTrusted(X509Certificate[] certs, String authType) {
                    }
                    public void checkServerTrusted(X509Certificate[] certs, String authType) {
                    }
                }
            };
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustAllCertificates, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
            URL url = new URL("https://localhost:44381/api/Personnes/info/"+cin);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                content+=line;
            }
            reader.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        Gson gson = new GsonBuilder().create();
        ProprioDTO proprio = gson.fromJson(content, ProprioDTO.class);
        return proprio;
    }
}
