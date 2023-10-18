/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import dto.CompteDTO;
import dto.DeviseDTO;
import dto.TransactionDTO;
import dto.TransfertDTO;
import entityBean.Connexion;
import entityBean.TransfertEntity;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author Antsa
 */
@Stateless
public class Transfert implements TransfertRemote, TransfertLocal {

    public TransfertDTO getById(String idTransfert)
    {
        TransfertDTO tf=new TransfertDTO();
        return tf;
    }
    @Override
    public void insertTransfert(String numCompte1,String numCompte2,double somme,int idDevise,Timestamp dateTransfert) throws Exception
    {
        Connection c=Connexion.getConnect("oracle");
        double solde=new Transaction().calculSolde(new Compte().getById(c,numCompte1).gettransactions());
        Date daty=Date.valueOf(dateTransfert.toString().split(" ")[0]);
        DeviseDTO devise=new Devise().getById(c,daty,idDevise);
        if(somme<=0){
            throw new Exception("Veuillez entrer une somme valide");
        }
        else if(somme*devise.getvaleur()>solde){
            throw new Exception("Votre solde est insuffisant : "+solde +"Ar. Veuillez verifier le montant a envoyer");
        }
        else if(numCompte1.equals(numCompte2))
        {
            throw new Exception("Les deux comptes ne devront pas etre les memes");
        }
        else{
            TransfertEntity.insertTransfert(c,numCompte1,numCompte2,somme,idDevise,dateTransfert);
        }
        c.close();
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
        int idseq=Integer.valueOf(TransfertEntity.getid(con));
        String idok=this.completerZero(7,idseq);
        idok="TRNF"+idok;
        return idok;
     }
}
