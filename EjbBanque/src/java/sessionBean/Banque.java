/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import dto.BanqueDTO;
import dto.CompteDTO;
import dto.TransactionDTO;
import entityBean.BanqueEntity;
import entityBean.Connexion;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.ejb.Stateless;

/**
 *
 * @author Antsa
 */
@Stateless
public class Banque implements BanqueRemote, BanqueLocal {
    @Override
    public HashMap<CompteDTO,Double> getSolde(String cin,String idBanque) throws Exception
    {
        System.out.println("abj");
        Banque b=new Banque();
        ArrayList<CompteDTO> compte=b.getCompte(cin,idBanque);
        HashMap<CompteDTO,Double> listesolde=new HashMap<CompteDTO,Double>();
        for(int i=0;i<compte.size();i++)
        {
            ArrayList<TransactionDTO> transacts=b.getTransactions(compte.get(i).getnumCompte(), idBanque);
            double solde=new Transaction().calculSolde(transacts);
            listesolde.put(compte.get(i),solde);
        }
        return listesolde;
    }
    @Override
    public ArrayList<BanqueDTO> getSolde(String cin) throws Exception
    {
        Banque b=new Banque();
        ArrayList<BanqueDTO> listB=b.getBanque(cin);
        for(int i=0;i<listB.size();i++)
        {
            listB.get(i).setcompte(b.getCompte(cin, listB.get(i).getidBanque()));
        }
        return listB;
    }
    @Override
    public ArrayList<CompteDTO> getCompte(String cin,String idBanque) throws Exception
    {
        Connection con=Connexion.getConnect("oracle");
        ArrayList<CompteDTO> compte=BanqueEntity.getCompte(con,cin,idBanque);
        for(int i=0;i<compte.size();i++)
        {
            compte.get(i).setsolde(new Transaction().calculSolde(compte.get(i).gettransactions()));
        }
        con.close();
        return compte;
    }
    @Override
    public ArrayList<TransactionDTO> getTransactions(String numCompte,String idBanque) throws Exception{
        Connection con=Connexion.getConnect("oracle");
        ArrayList<TransactionDTO> transactions=BanqueEntity.getTransactions(con,numCompte,idBanque);
        con.close();
        return transactions;
    }
    @Override
    public BanqueDTO getById(Connection con,String idBanque) throws Exception
    {
        int c=0;
        if(con==null)
        {
            con=Connexion.getConnect("oracle");
            c=1;
        }
        BanqueDTO ba=BanqueEntity.getById(con,idBanque);
        if(c==1)
        {
            con.close();
        }
        return ba;
    }
    
    @Override
    public ArrayList<BanqueDTO> getBanque(String cin) throws Exception{
        Connection con=Connexion.getConnect("oracle");
        ArrayList<BanqueDTO> banque=BanqueEntity.getBanque(con,cin);
        con.close();
        return banque;
    }
    
}
