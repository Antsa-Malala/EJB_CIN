/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

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
public interface TransactionRemote extends Serializable {
    public double calculSolde(ArrayList<TransactionDTO> liste) throws Exception;
    public String getlastId(Connection con) throws Exception;
    public String completerZero(int longPK, int seq);
    public String getId(Connection con) throws Exception;
}
