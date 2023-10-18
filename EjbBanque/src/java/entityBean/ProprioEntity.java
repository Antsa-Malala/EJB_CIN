/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityBean;

import dto.BanqueDTO;
import dto.ProprioDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Antsa
 */
public class ProprioEntity {
    public static ProprioDTO getById(Connection con,String cin) throws Exception
    {
        ProprioDTO b=null;
        Statement st = null;
        ResultSet res = null;
        int co=0;
        try{
            if(con==null)
            {
                con=Connexion.getConnect("oracle");
                co=1;
            }
            String requete = "select * from proprio where cin='"+cin+"'";
            System.out.println(requete);
            st = con.createStatement();
            res = st.executeQuery(requete);
            while(res.next())
            {
                b=new ProprioDTO(res.getString("cin"),res.getString("nom"),res.getString("prenom"),res.getString("sexe"),res.getDate("dateNaissance"),res.getString("contact"),res.getString("Adresse"));
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
}
