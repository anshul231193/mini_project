/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.service;

import com.sample.model.Customer;
import com.sample.repository.CustomerRepository;
import com.sample.repository.HibernateCustomerRepositoryImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author anshul
 */
public class CustomerServiceImpl implements CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
