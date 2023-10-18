/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityBean;

import dto.BanqueDTO;
import dto.CompteDTO;
import dto.TransactionDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import sessionBean.Banque;
import sessionBean.Proprio;
import sessionBean.Compte;
import sessionBean.Transaction;

/**
 *
 * @author Antsa
 */
public class BanqueEntity {
    public static ArrayList<String> getAll(Connection con)throws Exception{
        ArrayList <String> liste = new ArrayList <String>();
        Statement st = null;
        ResultSet res = null;
        int co=0;
        try{
            if(con==null)
            {
                con=Connexion.getConnect("oracle");
                co=1;
            }
            String requete = "select * from banky";
            st = con.createStatement();
            res = st.executeQuery(requete);
            while(res.next())
            {
                String p=res.getString("nomBanque");
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
    
    
    public static ArrayList<CompteDTO> getCompte(Connection con,String cin,String idBanque) throws Exception
    {
        ArrayList <CompteDTO> liste = new ArrayList <CompteDTO>();
        Statement st = null;
        ResultSet res = null;
        int co=0;
        try{
            if(con==null)
            {
                con=Connexion.getConnect("oracle");
                co=1;
            }
            String requete = "";
            if(idBanque.equals("")||idBanque==null)
            {
                requete="select * from kaonty where cin='"+cin+"'";
            }
            else{
                requete="select * from kaonty where cin='"+cin+"' and idBanque='"+idBanque+"'";
            }
            System.out.println(requete);
            st = con.createStatement();
            res = st.executeQuery(requete);
            while(res.next())
            {
                CompteDTO c=new CompteDTO(res.getString("numCompte"),new Proprio().getById(con,cin),new Banque().getById(con,res.getString("idBanque")),res.getString("typeCompte"),res.getDate("datecreation"));
                ArrayList<TransactionDTO> tra=new Compte().getTransactions(c.getnumCompte(), idBanque);
                c.settransactions(tra);
                liste.add(c);
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
    
    public static BanqueDTO getById(Connection con,String idBanque) throws Exception
    {
        BanqueDTO b=null;
        Statement st = null;
        ResultSet res = null;
        int co=0;
        try{
            if(con==null)
            {
                con=Connexion.getConnect("oracle");
                co=1;
            }
            String requete = "select * from banky where idBanque='"+idBanque+"'";
            System.out.println(requete);
            st = con.createStatement();
            res = st.executeQuery(requete);
            while(res.next())
            {
                b=new BanqueDTO(res.getString("idBanque"),res.getString("nomBanque"),res.getString("adresseBanque"),res.getString("contactBanque"),res.getString("typebanque"));
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
      return b;
    }
    
    public static ArrayList<TransactionDTO> getTransactions(Connection con,String numCompte,String idBanque) throws Exception{
        ArrayList<TransactionDTO> liste=new ArrayList<TransactionDTO>();
         Statement st = null;
        ResultSet res = null;
        int co=0;
        try{
            if(con==null)
            {
                con=Connexion.getConnect("oracle");
                co=1;
            }
            String requete = "select * from transacts where numCompte='"+numCompte+"' and idBanque='"+idBanque+"'";
            System.out.println(requete);
            st = con.createStatement();
            res = st.executeQuery(requete);
            while(res.next())
            {
                TransactionDTO t=new TransactionDTO(res.getString("idTransaction"),res.getString("typeTransaction"),res.getDouble("montant"),res.getDate("dateTransaction"));
                liste.add(t);
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
    
     public static ArrayList<BanqueDTO> getBanque(Connection con,String cin) throws Exception
    {
        ArrayList <BanqueDTO> liste = new ArrayList <BanqueDTO>();
        Statement st = null;
        ResultSet res = null;
        Banque b=new Banque();
        int co=0;
        try{
            if(con==null)
            {
                con=Connexion.getConnect("oracle");
                co=1;
            }
            String requete="select distinct(idBanque) from kaonty where cin='"+cin+"'";
            st = con.createStatement();
            res = st.executeQuery(requete);
            while(res.next())
            {
                liste.add(b.getById(con,res.getString("idBanque")));
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
}
