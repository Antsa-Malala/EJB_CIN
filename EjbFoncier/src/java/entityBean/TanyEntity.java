/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityBean;

import Fonce.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import dto.TanyDTO;
import sessionBean.Proprietaire;

/**
 *
 * @author Antsa
 */
public class TanyEntity {
    
    public static ArrayList<String> getAll(Connection con)throws Exception{
        ArrayList <String> liste = new ArrayList <String>();
        Statement st = null;
        ResultSet res = null;
        int co=0;
        try{
            if(con==null)
            {
                con=Connexion.getConnect("postgres");
                co=1;
            }
            String requete = "select * from tany";
            st = con.createStatement();
            res = st.executeQuery(requete);
            while(res.next())
            {
                String p=res.getString("numCadastre");
                liste.add(p);
            }
        }
        catch(Exception ex){
            throw ex;
        }
        finally{

            if( res != null ){
                res.close();
            }
            if(st != null ){
                st.close();
            }
            if(co==1)
            {
                con.close();
            }
        }
        return liste;
    }
    public static ArrayList<TanyDTO> getTany(Connection con,String cin)throws Exception{
        ArrayList <TanyDTO> liste = new ArrayList <TanyDTO>();
        Statement st = null;
        ResultSet res = null;
        int co=0;
        try{
            if(con==null)
            {
                con=Connexion.getConnect("postgres");
                co=1;
            }
            String requete = "select * from propriete where cin='"+cin+"'";
            System.out.println("tyy"+requete);
            st = con.createStatement();
            res = st.executeQuery(requete);
                 System.out.println("de aona2");
            while(res.next())
            {
                TanyDTO tany=new TanyDTO(res.getString("numcadastre"),res.getString("adressetany"),res.getDouble("superficie"),res.getString("typetany"),new Proprietaire().getById(cin),res.getDate("dateacquisition"));
                liste.add(tany);
                System.out.println("ty ndrayy"+requete);
            }
        }
        catch(Exception ex){
            throw ex;
        }
        finally{

            if( res != null ){
                res.close();
            }
            if(st != null ){
                st.close();
            }
            if(co==1)
            {
                con.close();
            }
        }
        return liste;
    }
    
    public static String getDernierPro(Connection con,String numCadastre) throws Exception
    {
        String prop="";
        Statement st = null;
        ResultSet res = null;
        int co=0;
        try{
            if(con==null)
            {
                con=Connexion.getConnect("postgres");
                co=1;
            }
            String requete = " select * from proprietaire where numcadastre='"+numCadastre+"' and dateacquisition=(select max(dateacquisition) from proprietaire where numcadastre='"+numCadastre+"')";
            st = con.createStatement();
            res = st.executeQuery(requete);
            while(res.next())
            {
               prop=res.getString("cin");
            }
        }
        catch(Exception ex){
            throw ex;
        }
        finally{

            if( res != null ){
                res.close();
            }
            if(st != null ){
                st.close();
            }
            if(co==1)
            {
                con.close();
            }
        }
        return prop;
    }
    
    
     public void insert(Connection con,TanyDTO tany) throws Exception{
            PreparedStatement st = null;
            int co=0;
            try{
                if(con==null)
                {
                    con = Connexion.getConnect("");
                    co=1;
                }
                String requete = "insert into tany values (default,?,?,?)";
                st = con.prepareStatement(requete);
                st.setString(1,tany.getnumCadastre());
                st.setString(2,tany.getadresseTany());
                st.setDouble(3, tany.getsuperficie());
                st.execute();
                }
            catch(Exception ex){
                throw ex;
            }
            finally{
                if(st != null ){
                    st.close();
                }
                if( co==1 ){
                    con.close();
                }
            }
    }
}
