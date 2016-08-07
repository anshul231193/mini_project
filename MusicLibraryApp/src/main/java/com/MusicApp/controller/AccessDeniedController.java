/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MusicApp.controller;

import org.springframework.stereotype.Controller;
import java.security.Principal;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author anshul
 */
@Controller
public class AccessDeniedController {
//    @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
//   public String welcomePage(Model model) {
//       model.addAttribute("title", "Welcome");
//       model.addAttribute("message", "This is welcome page!");
//       return "welcomePage";
//   }
 
//   @RequestMapping(value = "/admin", method = RequestMethod.GET)
//   public String adminPage(Model model) {
//       return "adminPage";
//   }
 
//   @RequestMapping(value = "/login", method = RequestMethod.GET)
//   public String loginPage(Model model ) {
//      
//       return "loginPage";
//   }
 
//   @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
//   public String logoutSuccessfulPage(Model model) {
//       model.addAttribute("title", "Logout");
//       return "logoutSuccessfulPage";
//   }
 
    
   //method to redirect to accessdenied page when not authorized
   @RequestMapping(value = "/403", method = RequestMethod.GET)
   public String accessDenied(Model model, Principal principal) {
        
       if (principal != null) {
           model.addAttribute("message", "Hi " + principal.getName()
                   + "<br> You do not have permission to access this page!");
       } else {
           model.addAttribute("msg",
                   "You do not have permission to access this page!");
       }
       return "403Page";
   }
}
