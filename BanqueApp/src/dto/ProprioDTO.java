/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Antsa
 */
public class ProprioDTO implements Serializable{
    String cin;
    String nom;
    String prenom;
    String sexe;
    String dateNaissance;
    String contact;
    String adresse;
    float poids;
    float taille;

    public String getcin()
    {
        return this.cin;
    }
    public void setcin(String cin) throws Exception
    {
        if(ProprioDTO.isNumeric(cin))
        {
            this.cin=cin;
        }
        else{
            throw new Exception("CIN invalide");
        }
    }
    
    public static boolean isNumeric(String texte)
    {
        for(Character c : texte.toCharArray()) {
            if (!Character.isDigit(c) && !c.toString().equals("\\.")) {
                return false;
            }
        }
        return true;
    }
    public String getnom() {
        return nom;
    }

    public void setnom(String nom) {
        this.nom = nom;
    }

    public String getprenom() {
        return prenom;
    }

    public void setprenom(String prenom) {
        this.prenom = prenom;
    }

    public String getsexe() {
        return sexe;
    }

    public void setsexe(String sexe) {
        this.sexe = sexe;
    }

    public Date getdateNaissance() {
        System.out.println(this.dateNaissance.split("T")[0]);
         return Date.valueOf(this.dateNaissance.split("T")[0]);
    }

    public void setdateNaissance(Date dateN) throws Exception {
        this.dateNaissance = dateN.toString();
    }
    
    public void setdateNaissance(String date)
    {
        this.dateNaissance=date;
    }

    public String getcontact() {
        return contact;
    }

    public void setcontact(String contact) {
        this.contact = contact;
    }

    public String getadresse() {
        return adresse;
    }

    public void setadresse(String adresse) {
        this.adresse = adresse;
    }
    
    public ProprioDTO( String cin,String nom, String prenom, String sexe, Date dateNaissance, String contact, String adresse) throws Exception{
        this.setcin(cin);
        this.setnom(nom);
        this.setprenom(prenom);
        this.setsexe(sexe);
        this.setdateNaissance(dateNaissance);
        this.setcontact(contact);
        this.setadresse(adresse);
    }
    
      public ProprioDTO( String cin,String nom, String prenom, String sexe, String dateNaissance, String contact, String adresse) throws Exception{
        this.setcin(cin);
        this.setnom(nom);
        this.setprenom(prenom);
        this.setsexe(sexe);
        this.setdateNaissance(dateNaissance);
        this.setcontact(contact);
        this.setadresse(adresse);
    }

    public ProprioDTO() {
    }
}
