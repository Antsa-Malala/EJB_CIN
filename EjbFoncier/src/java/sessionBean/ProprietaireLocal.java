/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import dto.ProprietaireDTO;
import java.io.Serializable;
import javax.ejb.Local;

/**
 *
 * @author Antsa
 */
@Local
public interface ProprietaireLocal extends Serializable{
     public ProprietaireDTO getById(String cin) throws Exception;
}
