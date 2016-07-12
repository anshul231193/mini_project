/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springsample;

import com.sample.repository.CustomerRepository;
import com.sample.repository.HibernateCustomerRepositoryImpl;
import com.sample.service.CustomerService;
import com.sample.service.CustomerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 *
 * @author anshul
 */

@Configuration
@ComponentScan({"com.sample"})
@PropertySource("app.properties")
public class AppConfig {
    
    @Bean
    public static PropertySourcesPlaceholderConfigurer 
        getPropertySourcesPlaceholderConfigurer() {
       return new PropertySourcesPlaceholderConfigurer();
    }
    
    @Bean(name = "customerService")
    @Scope("singleton")
    public CustomerService getCustomerService() {
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        customerService.setCustomerRepository(getCustomerRepository());
        return customerService;
    }
    
    @Bean(name = "customerRepository")
    public CustomerRepository getCustomerRepository() {
        return new HibernateCustomerRepositoryImpl();
    }
    
}
