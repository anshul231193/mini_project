/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MusicApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author anshul
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String indexPage() {
        return "index";
    }
    
}
