/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dummy.servlets;

/**
 *
 * @author anshul
 */
public class Address implements java.io.Serializable{
    
    //unique id 
    private int id;
    
    //street name and House number
    private String street;
    
    //City
    private String city;
    
    //State
    private String state;
    
    //Country
    private String country;

    public Address(int id,String street, String city, String state, String country) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
    }
    
    //getters and setters method
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getStreet() {
        return street;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public String getCountry() {
        return country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
}
