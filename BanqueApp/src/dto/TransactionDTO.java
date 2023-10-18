/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.sql.Date;

public class TransactionDTO implements Serializable{
    String idTransaction;
    String typeTransaction;
    double montant;
    Date daty;

    public String getidTransaction() {
        return idTransaction;
    }

    public void setidTransaction(String idTransaction) {
        this.idTransaction = idTransaction;
    }


    public String gettypeTransaction() {
        return typeTransaction;
    }

    public void settypeTransaction(String typeTransaction) {
        this.typeTransaction = typeTransaction;
    }
    public double getmontant() {
        return montant;
    }

    public void setmontant(double montant) {
        this.montant = montant;
    }
    
    public void setmontant(String montant) {
        double vola=Double.valueOf(montant);
        this.setmontant(vola);
    }
    
    public void setdaty(String daty)
    {
        Date date=Date.valueOf(daty);
        this.setdaty(date);
    }
    
    public Date getdaty() {
        return daty;
    }

    public void setdaty(Date daty) {
        this.daty = daty;
    }

    public TransactionDTO(String idTransaction, String typeTransaction, double montant, Date daty) {
        this.setidTransaction(idTransaction);
        this.settypeTransaction(typeTransaction);
        this.setmontant(montant);
        this.setdaty(daty);
    }
    public TransactionDTO(String idTransaction, String typeTransaction, String montant, String daty) {
        this.setidTransaction(idTransaction);
        this.settypeTransaction(typeTransaction);
        this.setmontant(montant);
        this.setdaty(daty);
    }

    public TransactionDTO() {
        
    }
    
    
    
}
