/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import dto.DeviseDTO;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
public class Devise implements DeviseRemote, DeviseLocal {
    @Override
    public ArrayList<DeviseDTO> getAll(Connection con,Date date) throws Exception
    {
        if(date==null)
        {
            date=Date.valueOf(LocalDateTime.now().toString().split("T")[0]);
        }
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
            URL url = new URL("https://localhost:44381/api/Devise/"+date);
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
        Type listType = new TypeToken<ArrayList<DeviseDTO>>() {}.getType();
        ArrayList<DeviseDTO> devises = gson.fromJson(content, listType);
        return devises;
    }
    
     @Override
    public ArrayList<DeviseDTO> getAllVente(Connection con,Date date) throws Exception
    {
        if(date==null)
        {
            date=Date.valueOf(LocalDateTime.now().toString().split("T")[0]);
        }
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
            URL url = new URL("https://localhost:44381/api/Devise/Vente/"+date);
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
        Type listType = new TypeToken<ArrayList<DeviseDTO>>() {}.getType();
        ArrayList<DeviseDTO> devises = gson.fromJson(content, listType);
        return devises;
    }
    
     @Override
    public DeviseDTO getById(Connection con,Date date,int id) throws Exception
    {
        if(date==null)
        {
            date=Date.valueOf(LocalDateTime.now().toString().split("T")[0]);
        }
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
            URL url = new URL("https://localhost:44381/api/Devise/"+id+"/"+date);
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
        DeviseDTO devise = gson.fromJson(content, DeviseDTO.class);
        return devise;
    }
    
     @Override
    public DeviseDTO getByIdVente(Connection con,Date date,int id) throws Exception
    {
        if(date==null)
        {
            date=Date.valueOf(LocalDateTime.now().toString().split("T")[0]);
        }
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
            URL url = new URL("https://localhost:44381/api/Devise/Vente/"+id+"/"+date);
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
        DeviseDTO devise = gson.fromJson(content, DeviseDTO.class);
        return devise;
    }
}
