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
public class BanqueDTO implements Serializable {
    String idBanque;
    String nom;
    String adresse;
    String contact;
    String type;
    ArrayList<CompteDTO> compte;

    public String getidBanque() {
        return idBanque;
    }

    public void setidBanque(String idBanque) throws Exception{
        if(idBanque.length()<=7)
        {
            this.idBanque = idBanque;        
        }
        else{
            throw new Exception("IdBanque invalide");
        }
    }

    public String getnom() {
        return nom;
    }

    public void setnom(String nom) {
        this.nom = nom;
    }

    public String getadresse() {
        return adresse;
    }

    public void setadresse(String adresse) {
        this.adresse = adresse;
    }

    public String getcontact() {
        return contact;
    }
    public static boolean isNumeric(String texte)
    {
        for(Character c : texte.toCharArray()) {
            if (!Character.isDigit(c) && !String.valueOf(c).matches("\\s+") && !Character.toString(c).equals("+")) {
                return false;
            }
        }
        return true;
    }
    public void setcontact(String contact){
        this.contact = contact;
    }

    public String gettype() {
        return type;
    }

    public void settype(String type) {
        this.type = type;
    }

    public ArrayList<CompteDTO> getcompte() {
        return compte;
    }

    public void setcompte(ArrayList<CompteDTO> compte) {
        this.compte = compte;
    }
    
    
    
    public BanqueDTO(String idBanque,String nom,String adresse,String contact,String type,ArrayList<CompteDTO> compte) throws Exception
    {
        this.setidBanque(idBanque);
        this.setnom(nom);
        this.setadresse(adresse);
        this.setcontact(contact);
        this.settype(type);
        this.setcompte(compte);
    }
    public BanqueDTO(String idBanque,String nom,String adresse,String contact,String type) throws Exception
    {
        this.setidBanque(idBanque);
        this.setnom(nom);
        this.setadresse(adresse);
        this.setcontact(contact);
        this.settype(type);
    }
    public BanqueDTO()
    {
        
    }
}
