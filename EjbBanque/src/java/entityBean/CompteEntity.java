/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityBean;

import dto.BanqueDTO;
import dto.CompteDTO;
import dto.ProprioDTO;
import dto.TransactionDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import sessionBean.Banque;
import sessionBean.Compte;
import sessionBean.Proprio;

/**
 *
 * @author Antsa
 */
public class CompteEntity {
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
            String requete = "select * from compte";
            st = con.createStatement();
            res = st.executeQuery(requete);
            while(res.next())
            {
                String p=res.getString("numCompte");
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
     
       public static CompteDTO getById(Connection con,String numCompte) throws Exception
    {
        CompteDTO c=null;
        Statement st = null;
        ResultSet res = null;
        int co=0;
        try{
            if(con==null)
            {
                con=Connexion.getConnect("oracle");
                co=1;
            }
            String requete = "select * from kaonty where numCompte='"+numCompte+"'";
            System.out.println(requete);
            st = con.createStatement();
            res = st.executeQuery(requete);
            while(res.next())
            {
                c=new CompteDTO(res.getString("numCompte"),new Proprio().getById(con,res.getString("cin")),new Banque().getById(con,res.getString("idBanque")),res.getString("typeCompte"),res.getDate("datecreation"));
                ArrayList<TransactionDTO> tra=new Compte().getTransactions(c.getnumCompte(), c.getbanque().getidBanque());
                c.settransactions(tra);
                System.out.println("coucouuuuu"+c.getbanque().getidBanque());
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
      return c;
    }
}
