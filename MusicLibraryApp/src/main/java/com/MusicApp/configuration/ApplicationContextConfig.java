/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MusicApp.configuration;

import com.MusicApp.daos.UserDAO;
import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author anshul
 */
@Configuration
@ComponentScan("com.MusicApp.*")
@EnableTransactionManagement
@Import({ WebSecurityConfig.class })
class ApplicationContextConfig {
 
  @Autowired
  private Environment env;
 
  @Autowired
  private UserDAO userDAO;
 
  @Bean
  public ResourceBundleMessageSource messageSource() {
      ResourceBundleMessageSource rb = new ResourceBundleMessageSource();
      // Load property in message/validator.properties
      rb.setBasenames(new String[] { "messages/validator" });
      return rb;
  }
 
  @Bean(name = "viewResolver")
  public InternalResourceViewResolver getViewResolver() {
      InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
      viewResolver.setPrefix("/WEB-INF/views/jsp/");
      viewResolver.setSuffix(".jsp");
      return viewResolver;
  }
 
  @Bean(name = "dataSource")
  public DataSource getDataSource() {
      DriverManagerDataSource dataSource = new DriverManagerDataSource();
 
      // See: datasouce-cfg.properties
      dataSource.setDriverClassName("org.postgresql.Driver");
      dataSource.setUrl("jdbc:postgresql://localhost:5432/MusicAppDB");
      dataSource.setUsername("postgres");
      dataSource.setPassword("test123");
 
      System.out.println("## getDataSource: " + dataSource);
 
      return dataSource;
  }
 
//        @Bean
//	public JavaMailSenderImpl javaMailSenderImpl(){
//		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//		mailSender.setHost("smtp.gmail.com");
//		mailSender.setPort(587);
//		//Set gmail email id
//		mailSender.setUsername("arvindraivns06@gmail.com");
//		//Set gmail email password
//		mailSender.setPassword("password");
//		Properties prop = mailSender.getJavaMailProperties();
//		prop.put("mail.transport.protocol", "smtp");
//		prop.put("mail.smtp.auth", "true");
//		prop.put("mail.smtp.starttls.enable", "true");
//		prop.put("mail.debug", "true");
//		return mailSender;
//	}
        
  // Transaction Manager
  @Autowired
  @Bean(name = "transactionManager")
  public DataSourceTransactionManager getTransactionManager(DataSource dataSource) {
      DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
 
      return transactionManager;
  }

}
