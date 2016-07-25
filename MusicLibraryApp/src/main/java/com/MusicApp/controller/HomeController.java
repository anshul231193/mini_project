/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MusicApp.controller;

import com.MusicApp.service.UserService;
import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author anshul
 */
@Controller
public class HomeController {
    
    HttpSession session;
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/home")
    public String homePage(HttpServletRequest request,
            @RequestParam(value="username",required=false) String username,
            @RequestParam(value="password",required=false) String pwd,
            Principal principal) {
        if(request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/admin";
        }
        if(principal!= null && principal.getName() != null){
            return "home";
        } else {
            return "redirect:/index";
        }
    }
}
