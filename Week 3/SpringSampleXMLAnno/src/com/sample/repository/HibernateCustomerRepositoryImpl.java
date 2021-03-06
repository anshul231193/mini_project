/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.repository;

import com.sample.model.Customer;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 *
 * @author anshul
 */
@Repository("customerRepository")
public class HibernateCustomerRepositoryImpl implements CustomerRepository {
    
    
    @Value("${someProperty}")
    private String someValue;
    
    @Override
    public List<Customer> findAll() {
        
        List<Customer> customers = new ArrayList<>();
        
        Customer customer = new Customer();
        customer.setFirstName(someValue);
        customer.setLastName("Gupta");
        customers.add(customer);
        
        return customers;
    }
    
}
