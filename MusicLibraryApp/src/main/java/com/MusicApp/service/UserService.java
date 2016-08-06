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
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
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
    
    @Autowired
    private MailSender mailSender;
    
//    @Autowired
//    private SimpleMailMessage alertMailMessage;
    
    public void sendMail(User user,String url) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("anshulgupta231193@gmail.com");
        message.setTo(user.getEmail());
        message.setSubject("Reset Password Link");
        message.setText("Hey "+user.getUsername()+"!!\nHere's your one time reset password link:-\n"
                + url+"/resetPassword?activationKey="+user.getActivationKey());
        mailSender.send(message);
    }
	     
//    public void sendAlertMail(String alert) {
//        SimpleMailMessage mailMessage = new SimpleMailMessage(alertMailMessage);
//        mailMessage.setText(alert);
//        mailSender.send(mailMessage);
//    }
            
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
            user.setActivationKey(RandomStringUtils.random(20, false, true));
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

    public User findByEmail(String email) {
        return userDAO.findByEmail(email);
    }

    public void save(User foundUser) {
        userDAO.saveOrUpdate(foundUser);
    }

    public User findByResetPasswordToken(String resetPasswordToken) {
        return userDAO.findByResetPasswordToken(resetPasswordToken);
    }

    public boolean checkIfUserExists(String username) {
        User user = userDAO.findUserInfo(username);
        if(user != null){
            return true;
        }
        return false;
    }

    public User getUserByActivationKey(String activationKey) {
        return userDAO.findByActivationKey(activationKey);
    }

    public void update(User user) {
        userDAO.saveOrUpdate(user);
    }

}
    

