/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import dto.TanyDTO;
import java.io.Serializable;
import java.util.ArrayList;
import javax.ejb.Remote;

/**
 *
 * @author Antsa
 */
@Remote
public interface TanyRemote  extends Serializable{
     public ArrayList<TanyDTO> liste_tany(String cin) throws Exception;
}
