/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.repository;

import com.sample.model.Customer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anshul
 */
public class HibernateCustomerRepositoryImpl implements CustomerRepository {
    
    @Override
    public List<Customer> findAll() {
        
        List<Customer> customers = new ArrayList<>();
        
        Customer customer = new Customer();
        customer.setFirstName("Anshul");
        customer.setLastName("Gupta");
        customers.add(customer);
        
        return customers;
    }
    
}
