/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Antsa
 */
public class DeviseDTO implements Serializable{
    int iddevise;
    String nom;
    double valeur;
    String dateDevise;

    public DeviseDTO() { }

    public DeviseDTO(int iddevise, String nom, double valeur, String dateDevise)
    {
        this.setiddevise(iddevise);
        this.setnom(nom);
        this.setvaleur(valeur);
        this.setdateDevise(dateDevise);
    }

    public DeviseDTO(int iddevise,String nom)
    {
        this.setiddevise(iddevise);
        this.setnom(nom);
    }

    public int getiddevise() {
        return iddevise;
    }

    public void setiddevise(int iddevise) {
        this.iddevise = iddevise;
    }

    public String getnom() {
        return nom;
    }

    public void setnom(String nom) {
        this.nom = nom;
    }

    public double getvaleur() {
        return valeur;
    }

    public void setvaleur(double valeur) {
        this.valeur = valeur;
    }

     public Date getdateDevise() {
         return Date.valueOf(this.dateDevise.split("T")[0]);
    }

    public void setdateDevise(Date dateN) throws Exception {
        this.dateDevise = dateN.toString();
    }
    
    public void setdateDevise(String date)
    {
        this.dateDevise=date;
    }
    
}
