/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MusicApp.configuration;

import java.util.Arrays;
import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

/**
 *
 * @author anshul
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {
 
    // Config UTF-8 Encoding.
   @Override
   public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
       StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
       stringConverter.setSupportedMediaTypes(Arrays.asList(new MediaType("text", "plain")));
       converters.add(stringConverter);
 
       // Add other converters ...
   }
 
   // Static Resource Config
   // equivalents for <mvc:resources/> tags
   @Override
   public void addResourceHandlers(ResourceHandlerRegistry registry) {
       registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
       registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
       registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
   }
 
   // Equivalent for <mvc:default-servlet-handler/> tag
   @Override
   public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
       configurer.enable();
   }
   
}
