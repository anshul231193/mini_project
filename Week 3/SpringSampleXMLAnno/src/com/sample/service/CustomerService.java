/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.service;

import com.sample.model.Customer;
import java.util.List;

/**
 *
 * @author anshul
 */
public interface CustomerService {

    List<Customer> findAll();
    
}
