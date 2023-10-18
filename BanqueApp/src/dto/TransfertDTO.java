/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Antsa
 */
public class TransfertDTO implements Serializable{
    String idTransfert;
    ArrayList<TransactionDTO> transactions;
    DeviseDTO devise;

    public String getidTransfert() {
        return idTransfert;
    }

    public void setidTransfert(String idTransfert) {
        this.idTransfert = idTransfert;
    }

    public ArrayList<TransactionDTO> gettransactions() {
        return transactions;
    }

    public void settransactions(ArrayList<TransactionDTO> transactions) {
        this.transactions = transactions;
    }

    public DeviseDTO getdevise() {
        return devise;
    }

    public void setdevise(DeviseDTO devise) {
        this.devise = devise;
    }

    public TransfertDTO(String idTransfert, ArrayList<TransactionDTO> transactions, DeviseDTO devise) {
        this.setidTransfert(idTransfert);
        this.settransactions(transactions);
        this.setdevise(devise);
    }

    public TransfertDTO(String idTransfert, DeviseDTO devise) {
        this.setidTransfert(idTransfert);
        this.setdevise(devise);
    }
    
    
    
    public TransfertDTO()
    {
        
    }
}
