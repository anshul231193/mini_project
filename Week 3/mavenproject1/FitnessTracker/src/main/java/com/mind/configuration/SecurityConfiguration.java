/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 *
 * @author anshul
 */

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) 
                                                            throws Exception {
     
        auth.inMemoryAuthentication().withUser("anshul").password("anshul123")
                                                                        .roles("User");
        auth.inMemoryAuthentication().withUser("root").password("root123")
                                                                        .roles("ADMIN");
        auth.inMemoryAuthentication().withUser("dba").password("anshul123")
                                                                        .roles("ADMIN","DBA");
        
        }
    
    protected void configure(HttpSecurity security) throws Exception {
    
        security.authorizeRequests()
                .antMatchers("/","/home").permitAll()
                .antMatchers("/admin/**").access("hasRole('ADMIN')")
                .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
                .and().formLogin()
                .and().exceptionHandling().accessDeniedPage("/Access_Denied");
        
    }
        
}
