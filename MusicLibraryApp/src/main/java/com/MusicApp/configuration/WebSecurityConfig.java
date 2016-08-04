/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MusicApp.configuration;

import com.MusicApp.authentication.MyDBAuthenticationService;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author anshul
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
        @Autowired
        MyDBAuthenticationService myDBAauthenticationService;
	
        @Autowired
	DataSource dataSource;
	
//	@Autowired
//	public void configAuthentication(AuthenticationManagerBuilder auth) 
//                                                            throws Exception {
//            System.out.println("HI "+dataSource);
//		
//	  auth.jdbcAuthentication().dataSource(dataSource)
//		.usersByUsernameQuery(
//			"select username, password,enabled from public.user where username=?")
//		.authoritiesByUsernameQuery(
//			"select username, role from public.user_roles where username=?");
//                        
//        }
        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

            // Users in memory.
            auth.inMemoryAuthentication().withUser("user1").password("12345").roles("USER");
            auth.inMemoryAuthentication().withUser("admin1").password("12345").roles("USER, ADMIN");
        
            // For User in database.
            auth.userDetailsService(myDBAauthenticationService);

        }
	
        @Bean
        @Override
        public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
        }

        @Override
	protected void configure(HttpSecurity http) throws Exception {

            System.out.println("*********");
            http.csrf();
            // The pages does not require login
        http.authorizeRequests().antMatchers("/","/index","register", "/welcome", "/login", "/logout").permitAll();
 
        // /userInfo page requires login as USER or ADMIN.
        // If no login, it will redirect to /login page.
        http.authorizeRequests().antMatchers("/userInfo,/mp3/**,/css/**,/js/**").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");
 
        // For ADMIN only.
        http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')");
 
        // When the user has logged in as XX.
        // But access a page that requires role YY,
        // AccessDeniedException will throw.
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
 
        // Config for Login Form
        http.authorizeRequests().and().formLogin()//
                // Submit URL of login page.
                .loginProcessingUrl("/j_spring_security_check") // Submit URL
                .loginPage("/index")//
                .defaultSuccessUrl("/home")//
                .failureUrl("/index?error=true")//
                .usernameParameter("username")//
                .passwordParameter("password")
                // Config for Logout Page
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");
//              http.authorizeRequests()
//		.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
//		.and()
//		  .formLogin().loginPage("/index")
//                      .loginProcessingUrl("/j_spring_security_check")
//                  .defaultSuccessUrl("/home").usernameParameter("username")
//                  .passwordParameter("password")
//		.and()
//		  .logout().logoutSuccessUrl("/index?logout")
//		.and()
////		  .exceptionHandling().accessDeniedPage("/403")
////		.and()
//		  .csrf();
////	  http.authorizeRequests()
////                  .antMatchers("/index","/").permitAll()
////		.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
////		.and()
////		  .formLogin().loginProcessingUrl("/j_spring_security_check") 
////                  .loginPage("/index").defaultSuccessUrl("/home")
////                  .failureUrl("/index?error")
////		  .usernameParameter("username").passwordParameter("password")
////		.and()
////		  .logout().logoutSuccessUrl("/index?logout")
////		.and()
////		  .exceptionHandling().accessDeniedPage("/403")
////		.and()
////		  .csrf();
            System.out.println();
	}
}
