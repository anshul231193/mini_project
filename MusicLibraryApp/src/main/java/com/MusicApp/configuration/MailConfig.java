/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MusicApp.configuration;

import java.util.Properties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 *
 * @author anshul
 */
@Configuration 
public class MailConfig {

    private String protocol="smtp"; 

    private String host="smtp.gmail.com"; 

    private int port=25; 

    private boolean auth=true; 

    private boolean starttls=true; 

    private String from; 

    private String username="anshulgupta231193@gmail.com"; 

    private String password="anshul@231193"; 
 
    @Bean 
    public JavaMailSender javaMailSender() { 
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl(); 
        Properties mailProperties = new Properties(); 
        mailProperties.put("mail.smtp.auth", auth); 
        mailProperties.put("mail.smtp.starttls.enable", starttls); 
        mailSender.setJavaMailProperties(mailProperties); 
        mailSender.setHost(host); 
        mailSender.setPort(port); 
        mailSender.setProtocol(protocol); 
        mailSender.setUsername(username); 
        mailSender.setPassword(password); 
        return mailSender; 
    } 
    
}
