/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import dto.ProprioDTO;
import java.io.Serializable;
import java.sql.Connection;
import javax.ejb.Remote;

/**
 *
 * @author Antsa
 */
@Remote
public interface ProprioRemote extends Serializable{
    public ProprioDTO getById(Connection con,String cin) throws Exception;
}
