/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dummy.servlets;

import java.util.HashSet;

/**
 *
 * @author anshul
 */
public class User implements java.io.Serializable {
        
        // name of User
        private String name;
        
        //E-mail of User
        private String email;
        
        //Password of User
        private String pswd;
        
        //Username of User
        private String username;
        
        //cell phone
        private long mobile;
        
        //Address of User
        HashSet<Address> address = new HashSet<Address>();
             
        public User(String name,String username,String pswd,String email, String mobile) {
            this.name = name;
            this.pswd = pswd;
            this.email = email;
            this.username = username;
            this.mobile = Long.parseLong(mobile);
        }
        //getter and setter methods
        public String getName() {
            return name;
        }
        
        public void setName(String name) {
            this.name = name;
        }
        
        public void setEmail(String email) {
            this.email = email;
        }
        
        public String getEmail() {
            return email;
        }
        
        public String getPswd() {
            return pswd;
        }
        
        public void setPswd(String pswd) {
            this.pswd = pswd;
        }
        
        public String getUserName() {
            return username;
        }
        
        public void setUserName(String name) {
            username = name;
        }
        
        public long getCellNumber() {
            return mobile;
        }
        
        public void setCellNumber(long number) {
            mobile = number;
        }
        
        public HashSet<Address> getAddress() {
            return address;
        }
        
        public void setAddress(Address adr) {
           if(address == null) {
               address = new HashSet<Address>();
               address.add(adr);
            }
           else { 
               address.add(adr);
            }
        }
}
