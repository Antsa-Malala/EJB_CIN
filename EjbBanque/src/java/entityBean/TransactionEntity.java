/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Antsa
 */
public class TransactionEntity {
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
            String requete = "select * from transaction";
            st = con.createStatement();
            res = st.executeQuery(requete);
            while(res.next())
            {
                String p=res.getString("idTransaction");
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
    
    public static String getlastId(Connection con)throws Exception{
        String lastId="";
        Statement st = null;
        ResultSet res = null;
        int co=0;
        try{
            if(con==null)
            {
                con=Connexion.getConnect("oracle");
                co=1;
            }
            String requete = "select max(idtransaction) from transactions";
            st = con.createStatement();
            res = st.executeQuery(requete);
            while(res.next())
            {
               lastId=res.getString("idTransaction");
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
            String requete = "select getseqtransaction as id from dual";
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
