/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author Antsa
 */
public class TanyDTO implements Serializable{
    String numCadastre;
    String adresseTany;
    double superficie;
    String typeTany;
    ProprietaireDTO proprio;
    Date dateAcquisition;
    
    public String getnumCadastre() {
        return numCadastre;
    }

    public void setnumCadastre(String numCadastre) {
        this.numCadastre = numCadastre;
    }

    public String getadresseTany() {
        return adresseTany;
    }

    public void setadresseTany(String adresseTany) {
        this.adresseTany = adresseTany;
    }

    public double getsuperficie() throws Exception{
         if(this.superficie>0)
        {
            return superficie;
        }
        else{
            throw new Exception("La valeur de la superficie tany est invalide ");
        }
    }

    public void setsuperficie(double superficie) throws Exception{
        if(superficie>0)
        {
            this.superficie = superficie;
        }
        else{
            throw new Exception("superficie tany invalide");
        }
    }
    public void setsuperficie(String superficie) throws Exception{
        if(TanyDTO.isNumeric(superficie))
        {
            double superf=Double.valueOf(superficie);
            this.setsuperficie(superf); 
        }
        else{
            throw new Exception("La superficie de tany entree est invalide");
        }
    }

    public String gettypeTany() {
        return typeTany;
    }

    public void settypeTany(String typeTany) {
        this.typeTany = typeTany;
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

    public ProprietaireDTO getproprio() throws Exception{
        if(this.proprio!=null)
        {
            return proprio;
        }
        else{
            throw new Exception("proprio null");
        }
    }

    public void setproprio(ProprietaireDTO p) throws Exception{
        if(p!=null)
        {
            this.proprio = p;
        }
        else{
            throw new Exception("proprio entree null");
        }
    }
    
    public void setdateAcquisition(Date acquisition)
    {
        this.dateAcquisition=acquisition;
    }
     public void setdateAcquisition(String acquisition)
    {
        this.dateAcquisition=Date.valueOf(acquisition);
    }

    public TanyDTO( String numCadastre, String adresseTany, double superficie, String typeTany, ProprietaireDTO proprio,Date acquisition)throws Exception {
        this.setnumCadastre(numCadastre);
        this.setadresseTany(adresseTany);
        this.setsuperficie(superficie);
        this.settypeTany(typeTany);
        this.setproprio(proprio);
        this.setdateAcquisition(acquisition);
    }
    public TanyDTO( String numCadastre, String adresseTany, String superficie, String typeTany, ProprietaireDTO proprio,String acquisition)throws Exception {
        this.setnumCadastre(numCadastre);
        this.setadresseTany(adresseTany);
        this.setsuperficie(superficie);
        this.settypeTany(typeTany);
        this.setproprio(proprio);
        this.setdateAcquisition(acquisition);
    }
    public TanyDTO( String numCadastre, String adresseTany, double superficie, String typeTany,Date acquisition) throws Exception{
        this.setnumCadastre(numCadastre);
        this.setadresseTany(adresseTany);
        this.setsuperficie(superficie);
        this.settypeTany(typeTany);
        this.setdateAcquisition(acquisition);
    }
    public TanyDTO(String numCadastre, String adresseTany, String superficie, String typeTany,String acquisition)throws Exception {
        this.setnumCadastre(numCadastre);
        this.setadresseTany(adresseTany);
        this.setsuperficie(superficie);
        this.settypeTany(typeTany);
        this.setdateAcquisition(acquisition);
    }
    public TanyDTO()
    {
        
    }
}
