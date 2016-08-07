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
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 *
 * Mail Configuration Class
 */
@Configuration
@PropertySource(value="classpath:../mail.properties")
public class MailConfig {

    //smtp protocol
    @Value("${mail.protocol}")
    private String protocol; 

    //smtp host
    @Value("${mail.host}")
    private String host; 

    //smtp port number
    @Value("${mail.port}")
    private int port; 

    //mail authentication allowed
    @Value("${mail.auth}")
    private boolean auth; 

    //mail starttls allowed
    @Value("${mail.starttls}")
    private boolean starttls; 

    //mail from
    private String from; 

    //mail username
    @Value("${mail.username}")
    private String username; 

    //mail password
    @Value("${mail.pswd}")
    private String password; 
 
    //Bean to configure mail properties
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
    
    //Bean to use properties file
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        PropertySourcesPlaceholderConfigurer pspc = 
                new PropertySourcesPlaceholderConfigurer();
//        pspc.setLocation(new ClassPathResource("classpath:../*.properties"));
        return pspc;
    }
}
