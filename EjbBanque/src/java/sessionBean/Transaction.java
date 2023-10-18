/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import dto.TransactionDTO;
import entityBean.TransactionEntity;
import java.sql.Connection;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author Antsa
 */
@Stateless
public class Transaction implements TransactionRemote, TransactionLocal {
    @Override
    public double calculSolde(ArrayList<TransactionDTO> liste) throws Exception
    {
        double solde=0;
        for(int i=0;i<liste.size();i++)
        {
            if(liste.get(i).gettypeTransaction().equals("Depot") || liste.get(i).gettypeTransaction().equals("Recu"))
            {
                solde+=liste.get(i).getmontant();
            }
            else if(liste.get(i).gettypeTransaction().equals("Retrait") || liste.get(i).gettypeTransaction().equals("Envoie")){
                solde-=liste.get(i).getmontant();
            }
        }
        return solde;
    }
    @Override
     public String getlastId(Connection con) throws Exception{
         String lastId=TransactionEntity.getlastId(con);
         return lastId;
     }
     @Override
     public String completerZero(int longPK, int seq) {
        String valiny = "";
        int sequence = String.valueOf(seq).length();
        while (valiny.length() + 4 + sequence < longPK) {
            valiny += "0";
        }
        valiny += String.valueOf(seq);
        return valiny;
    }
     @Override
     public String getId(Connection con) throws Exception
     {
         int idseq=TransactionEntity.getid(con);
         System.out.println(idseq);
         String idok=this.completerZero(7,idseq);
         idok="TRNS"+idok;
         return idok;
     }
}
