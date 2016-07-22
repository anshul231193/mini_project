/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MusicApp.daos;

import com.MusicApp.model.UserRole;
import java.util.List;

/**
 *
 * @author anshul
 */
public interface UserRolesDAO {
    
    public void saveOrUpdate(UserRole userRole);
     
    public void delete(int user_role_Id);
     
    public UserRole get(int userRoleId);
     
    public List<UserRole> list();
}
