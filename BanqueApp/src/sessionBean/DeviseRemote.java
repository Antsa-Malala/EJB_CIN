/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import dto.DeviseDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import javax.ejb.Remote;

/**
 *
 * @author Antsa
 */
@Remote
public interface DeviseRemote extends Serializable{
     public ArrayList<DeviseDTO> getAll(Connection con,Date date) throws Exception;
         public DeviseDTO getById(Connection con,Date date,int id) throws Exception;
             public ArrayList<DeviseDTO> getAllVente(Connection con,Date date) throws Exception;
             public DeviseDTO getByIdVente(Connection con,Date date,int id) throws Exception;
}
