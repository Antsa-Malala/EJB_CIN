/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Timestamp;
import javax.ejb.Local;

/**
 *
 * @author Antsa
 */
@Local
public interface TransfertLocal extends Serializable{
        public String completerZero(int longPK, int seq) ;
        public String getId(Connection con) throws Exception;
        public void insertTransfert(String numCompte1,String numCompte2,double somme,int idDevise,Timestamp dateTransfert) throws Exception;
}
