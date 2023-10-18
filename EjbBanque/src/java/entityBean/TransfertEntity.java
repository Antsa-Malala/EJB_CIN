/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityBean;

import dto.CompteDTO;
import dto.DeviseDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import sessionBean.Compte;
import sessionBean.Devise;
import sessionBean.Transaction;
import sessionBean.Transfert;

/**
 *
 * @author Antsa
 */
public class TransfertEntity {
    
    public static void insertTransfert(Connection con,String numCompte1,String numCompte2,double somme,int idDevise,Timestamp dateTransfert) throws Exception{
            PreparedStatement st = null;
            int co=0;
            try{
                if(con==null)
                {
                    con = Connexion.getConnect("oracle");
                    co=1;
                }
                Date daty=Date.valueOf(dateTransfert.toString().split(" ")[0]);
                DeviseDTO devise=new Devise().getById(con,daty,idDevise);
                DeviseDTO deviseVente=new Devise().getByIdVente(con, daty, idDevise);
                double sommedevise=somme*devise.getvaleur();
                System.out.println("Vbceojdlvbdj"+devise.getvaleur());
                double sommedeviseVente=somme*deviseVente.getvaleur();
                 System.out.println("GUBJO"+deviseVente.getvaleur());
                String idTransaction1=new Transaction().getId(con);
                String idTransaction2=new Transaction().getId(con);
                CompteDTO compte1=new Compte().getById(con,numCompte1);
                CompteDTO compte2=new Compte().getById(con,numCompte2);
                
                String requete1 = "insert into transactions values (?,?,?,?,?,?)";
                st = con.prepareStatement(requete1);
                st.setString(1,idTransaction1);
                st.setString(2,numCompte1);
                st.setString(3,compte1.getbanque().getidBanque());
                st.setInt(4, 6);
                st.setDouble(5,sommedevise);
                st.setTimestamp(6,dateTransfert);
                st.execute();
                
                String requete2 = "insert into transactions values (?,?,?,?,?,?)";
                st = con.prepareStatement(requete2);
                st.setString(1,idTransaction2);
                st.setString(2,numCompte2);
                st.setString(3,compte2.getbanque().getidBanque());
                st.setInt(4, 7);
                st.setDouble(5,sommedeviseVente);
                st.setTimestamp(6,dateTransfert);
                st.execute();
                System.out.println("ok");
                
                
                String idtransfert=new Transfert().getId(con);
                String requete3 = "insert into transfert values (?,?,?,?)";
                st = con.prepareStatement(requete3);
                st.setString(1,idtransfert);
                st.setString(2,idTransaction1);
                st.setString(3, idTransaction2);
                st.setInt(4,idDevise);
                st.execute();
                
                con.commit();
                
                }
            catch(Exception ex){
                try{
                    con.rollback();
                    throw ex;
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                    throw e;
                }
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
    
    public static int getid(Connection con) throws Exception
    {
        int lastId=0;
        Statement st = null;
        ResultSet res = null;
        int co=0;
        try{
            if(con==null)
            {
                con=Connexion.getConnect("oracle");
                co=1;
            }
            String requete = "select getseqtransfert as id from dual";
            st = con.createStatement();
            res = st.executeQuery(requete);
            while(res.next())
            {
               lastId=res.getInt("id");
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
        return lastId;
    }
}