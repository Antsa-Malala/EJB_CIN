/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import Fonce.Connexion;
import dto.TanyDTO;
import entityBean.TanyEntity;
import java.sql.Connection;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author Antsa
 */
@Stateless
public class Tany implements TanyRemote, TanyLocal {
    @Override
    public ArrayList<TanyDTO> liste_tany(String cin) throws Exception
    {
        Connection c=Connexion.getConnect("postgres");
        ArrayList<TanyDTO> liste=TanyEntity.getTany(c,cin);  
        ArrayList<TanyDTO> anazy=new ArrayList<TanyDTO>();
        for(int i=0;i<liste.size();i++)
        {
            String cinPro=TanyEntity.getDernierPro(c,liste.get(i).getnumCadastre());
            if(cinPro.equals(cin))
            {
                anazy.add(liste.get(i));
            }
        }
        c.close();
        return anazy;
    }
}
