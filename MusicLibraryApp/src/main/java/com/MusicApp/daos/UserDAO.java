/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MusicApp.daos;

import com.MusicApp.model.User;
import java.util.List;

/**
 *
 * @author anshul
 */
public interface UserDAO {
    
    public void saveOrUpdate(User user);
     
    public void delete(int userId);
     
    public User get(int userId);
    
    public User getByUserName(String username);
     
    public List<User> list();
    
    public List<String> getUserRoles(String userName);

    public User findUserInfo(String username);
    
    public User findByEmail(String email);

    public User findByResetPasswordToken(String token);
            
}
