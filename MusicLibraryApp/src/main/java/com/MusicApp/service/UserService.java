/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MusicApp.service;

import com.MusicApp.daos.UserDAO;
import com.MusicApp.daos.UserRolesDAO;
import com.MusicApp.model.User;
import com.MusicApp.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author anshul
 */
@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;
    
    @Autowired
    private UserRolesDAO userRolesDAO;
    
    public int createOrUpdate(String name, String username, 
                String pwd, String email, int age, String address) {
        
        User user = userDAO.getByUserName(username);
        UserRole userRole;
        if(user == null) {
            user = new User();
            user.setName(name);
            user.setUsername(username);
            user.setPassword(pwd);
            user.setAge(age);
            user.setEmail(email);
            user.setAddress(address);
            userDAO.saveOrUpdate(user);
            userRole = new UserRole();
            userRole.setUsername(username);
            userRole.setRoles("USER");
            userRolesDAO.saveOrUpdate(userRole);
   
        } else {
            return -1;
        }
        return 0;
    }

    private void saveOrUpdateUserRole(String username) {
    
        
    }

    public boolean checkIfUserExists(String username, String pwd) {
        
        User user = userDAO.getByUserName(username);
        if(user == null){
            return false;
        }
        return true;
    }

    public User getUser(String username) {
        return userDAO.getByUserName(username);
    }
    
}
