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
 * @author anshul
 */
@Configuration
@PropertySource(value="classpath:../mail.properties")
public class MailConfig {

    @Value("${mail.protocol}")
    private String protocol; 

    @Value("${mail.host}")
    private String host; 

    @Value("${mail.port}")
    private int port; 

    @Value("${mail.auth}")
    private boolean auth; 

    @Value("${mail.starttls}")
    private boolean starttls; 

    private String from; 

    @Value("${mail.username}")
    private String username; 

    @Value("${mail.pswd}")
    private String password; 
 
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
    
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        PropertySourcesPlaceholderConfigurer pspc = 
                new PropertySourcesPlaceholderConfigurer();
//        pspc.setLocation(new ClassPathResource("classpath:../*.properties"));
        return pspc;
    }
}
