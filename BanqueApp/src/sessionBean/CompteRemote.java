/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import dto.CompteDTO;
import dto.TransactionDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.util.ArrayList;
import javax.ejb.Remote;

/**
 *
 * @author Antsa
 */
@Remote
public interface CompteRemote extends Serializable{
  public CompteDTO getById(Connection con,String numCompte) throws Exception;
    public ArrayList<TransactionDTO> getTransactions(String numCompte,String idBanque) throws Exception;
}
