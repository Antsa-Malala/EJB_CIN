/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Antsa
 */
public class CompteDTO implements Serializable{
    String numCompte;
    ProprioDTO proprietaire;
    BanqueDTO banque;
    String typeCompte;
    Date dateCreation;
    ArrayList<TransactionDTO> transactions;
    double solde;
    
    public static boolean isNumeric(String texte)
    {
        for(Character c : texte.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    
    public String getnumCompte() {
        return numCompte;
    }

    public void setnumCompte(String numCompte) throws Exception{
        if(CompteDTO.isNumeric(numCompte))
        {
            this.numCompte = numCompte;
        }
        else
        {
            throw new Exception("Numero de compte invalide");
        }
    }

    public ProprioDTO getproprietaire() {
        return proprietaire;
    }

    public void setproprietaire(ProprioDTO proprietaire) {
        this.proprietaire = proprietaire;
    }

    public BanqueDTO getbanque() {
        return banque;
    }

    public void setbanque(BanqueDTO banque) {
        this.banque = banque;
    }

    public String gettypeCompte() {
        return typeCompte;
    }

    public void settypeCompte(String typeCompte) {
        this.typeCompte = typeCompte;
    }

    public Date getdateCreation() {
        return dateCreation;
    }

    public void setdateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
    
     public void setdateCreation(String dateCreation) {
        Date daty=Date.valueOf(dateCreation);
        this.setdateCreation(daty);
    }
    
    public void settransactions(ArrayList<TransactionDTO> tra)
    {
        this.transactions=tra;   
    }
    public ArrayList<TransactionDTO> gettransactions()
    {
        return this.transactions;
    }
    
    public void setsolde(double solde) throws Exception
    {
        if(solde<0)
        {
            solde=0;
            throw new Exception("soldeinvalide");
        }
        else{
            this.solde=solde;
        }
    }
    public double getsolde()
    {
        return this.solde;
    }
    
    public CompteDTO()
    {
        
    }

     public CompteDTO(String numCompte, ProprioDTO proprietaire, BanqueDTO banque, String typeCompte, Date dateCreation)throws Exception {
        this.setnumCompte(numCompte);
        this.setproprietaire(proprietaire);
        System.out.println("dddddddddddd"+banque.getnom());
        this.setbanque(banque);
        this.settypeCompte(typeCompte);
        this.setdateCreation(dateCreation);
    }
    
    
        public CompteDTO(String numCompte, ProprioDTO proprietaire, BanqueDTO banque, String typeCompte, Date dateCreation,ArrayList<TransactionDTO> tra)throws Exception {
            this.setnumCompte(numCompte);
            this.setproprietaire(proprietaire);
            System.out.println("dddddddddddd"+banque.getnom());
            this.setbanque(banque);
            this.settypeCompte(typeCompte);
            this.setdateCreation(dateCreation);
            this.settransactions(tra);
        }
    
    public CompteDTO(String numCompte, ProprioDTO proprietaire, BanqueDTO banque, String typeCompte, String dateCreation)throws Exception {
        this.setnumCompte(numCompte);
        this.setproprietaire(proprietaire);
        this.setbanque(banque);
        this.settypeCompte(typeCompte);
        this.setdateCreation(dateCreation);
    }
    
    public CompteDTO(String numCompte, ProprioDTO proprietaire, BanqueDTO banque, String typeCompte, String dateCreation,ArrayList<TransactionDTO> tra)throws Exception {
        this.setnumCompte(numCompte);
        this.setproprietaire(proprietaire);
        this.setbanque(banque);
        this.settypeCompte(typeCompte);
        this.setdateCreation(dateCreation);
        this.settransactions(tra);
    }
}
