/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import dto.BanqueDTO;
import dto.CompteDTO;
import dto.TransactionDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.ejb.Remote;

/**
 *
 * @author Antsa
 */
@Remote
public interface BanqueRemote extends Serializable{
    public HashMap<CompteDTO,Double> getSolde(String cin,String idBanque) throws Exception;
    public ArrayList<CompteDTO> getCompte(String cin,String idBanque) throws Exception;
    public ArrayList<BanqueDTO> getBanque(String cin) throws Exception;
    public ArrayList<TransactionDTO> getTransactions(String numCompte,String idBanque) throws Exception;
    public BanqueDTO getById(Connection con,String idBanque) throws Exception;
    public ArrayList<BanqueDTO> getSolde(String cin) throws Exception;
}
