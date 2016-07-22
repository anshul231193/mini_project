/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MusicApp.model;

import java.util.List;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author anshul
 */
public class User {
    
    private int id;
    
    private String name;

    private String username;
    
    private String password;
    
    private String email;
    
    private String address;
    
    private int age;

    public User() {
    }

    public User(String username, String password) {
        this.password = password;
        this.username = username;
    }

    public User(String username, String password, List<GrantedAuthority> grantList) {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   
    
}
