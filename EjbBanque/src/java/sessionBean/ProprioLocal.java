/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import dto.ProprioDTO;
import java.sql.Connection;
import javax.ejb.Local;

/**
 *
 * @author Antsa
 */
@Local
public interface ProprioLocal {
     public ProprioDTO getById(Connection con,String cin) throws Exception;
}
