/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import dto.CompteDTO;
import dto.TransactionDTO;
import entityBean.BanqueEntity;
import entityBean.CompteEntity;
import entityBean.Connexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author Antsa
 */
@Stateless
public class Compte implements CompteRemote, CompteLocal {
    @Override
    public CompteDTO getById(Connection con,String numCompte) throws Exception
    {
        CompteDTO c=null;
        Statement st = null;
        ResultSet res = null;
        int co=0;
            try{
                if(con==null)
                {
                    con = Connexion.getConnect("oracle");
                    co=1;
                }
                c=CompteEntity.getById(con,numCompte);
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
    
    @Override
    public ArrayList<TransactionDTO> getTransactions(String numCompte,String idBanque) throws Exception{
        Connection con=Connexion.getConnect("oracle");
        ArrayList<TransactionDTO> transactions=BanqueEntity.getTransactions(con,numCompte,idBanque);
        con.close();
        return transactions;
    }
}
