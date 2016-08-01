/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MusicApp.controller;

import com.MusicApp.model.User;
import com.MusicApp.service.UserService;
import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author anshul
 */
@Controller
public class LoginController {
    
    @Autowired
    UserService userService;
    
    HttpSession session;

    @RequestMapping(value = "/index",method=RequestMethod.GET)
    public String indexPage(
            @RequestParam(value = "error",required = false) String error,
            @RequestParam(value = "logout",required = false) String logout,
            HttpServletRequest request,Principal principal) {
        
        if(logout != null) {
            request.setAttribute("flashKind", "success");
        }
        if(error != null) {
            request.setAttribute("flashKind", "warning");
        }
        if(request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/admin";
        }
        if(principal!= null && principal.getName() != null){
            return "redirect:/home";
        }
        return "index";
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(Principal principal,HttpServletRequest request) {
        
        if(request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/admin";
        }
        if(principal!= null && principal.getName() != null){
            return "redirect:/home";
        }

        return "register";
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@RequestParam("name") String name, 
            @RequestParam("username") String username,
            @RequestParam("pwd") String pwd,
            @RequestParam("email") String email,
            @RequestParam("age") int age,
            @RequestParam("address") String address,
            HttpServletRequest request
            ) {
        
        if(userService.createOrUpdate(name,username,pwd,email,age,address) == -1) {
            request.setAttribute("message","User Name already exists.");
            request.setAttribute("flashKind","warning");
        }else {
            request.setAttribute("flashKind","success");
            request.setAttribute("message", "Successfully registered");
        }
        return "register";
    }
    
    @RequestMapping(value = "/forgotPassword", method = RequestMethod.GET)
    public String forgetPassword(Principal principal,HttpServletRequest request){
        if(request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/admin";
        }
        if(principal!= null && principal.getName() != null){
            return "redirect:/home";
        }

        return "forget-password";
    }
    
    @RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
    public String resetPasswordLink(Model model,
            @RequestParam String username,
            HttpServletRequest request){
        if(userService.checkIfUserExists(username)) {
            String appUrl = 
            "http://" + request.getServerName() + 
            ":" + request.getServerPort() + 
            request.getContextPath();
            userService.sendMail(userService.getUser(username),appUrl);
            model.addAttribute("flashKind","success");
            model.addAttribute("msg","Reset Password Link sent to your registered mail.");
        } else {
            model.addAttribute("flashKind","warning");
            model.addAttribute("msg","Username doesn't exists");
        }
        return "forget-password";
    }
    
    @RequestMapping(value = "/resetPassword", method = RequestMethod.GET)
    public String resetPassword(Principal principal,HttpServletRequest request,
            Model model,
            @RequestParam String activationKey) throws Exception {
        if(request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/admin";
        }
        if(principal!= null && principal.getName() != null){
            return "redirect:/home";
        }
        User user = userService.getUserByActivationKey(activationKey);
        if(user == null){
            return "resetLinkExpire";
        }
        System.out.println(activationKey);
        model.addAttribute("user",user);
        return "reset-password";
    }
    
    @RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
    public String updatePassword(Model model,
            @RequestParam String pswd,
            @RequestParam String confirmpswd,
            @RequestParam String activationKey) {
        if(!pswd.equals(confirmpswd)) {
            model.addAttribute("msg","Password doesn't matches.");
            model.addAttribute("flashKind","warning");
            return "reset-password";
        } else {
            User user = userService.getUserByActivationKey(activationKey);
            if(user==null){
                return "Link Expired";
            }else {
                user.setPassword(pswd);
                System.out.println(user.getPassword());
                user.setActivationKey(RandomStringUtils.random(20, false, true));
                userService.update(user);
                model.addAttribute("msg","Password reset successfully");
                model.addAttribute("flashKind","success");
            }
        }
        return "redirect:/index";
    }
    
//	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
//	public ModelAndView defaultPage() {
//
//	  ModelAndView model = new ModelAndView();
//	  model.addObject("title", "Spring Security Login Form - Database Authentication");
//	  model.addObject("message", "This is default page!");
//	  model.setViewName("hello");
//	  return model;
//
//	}

	

//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
//		@RequestParam(value = "logout", required = false) String logout) {
//
//	  ModelAndView model = new ModelAndView();
//	  if (error != null) {
//		model.addObject("error", "Invalid username and password!");
//	  }
//
//	  if (logout != null) {
//		model.addObject("msg", "You've been logged out successfully.");
//	  }
//	  model.setViewName("login");
//
//	  return model;
//
//	}
	
//	@RequestMapping(value = "/403", method = RequestMethod.GET)
//	public ModelAndView accesssDenied() {
//
//	  ModelAndView model = new ModelAndView();
//		
//	  //check if user is login
//	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//	  if (!(auth instanceof AnonymousAuthenticationToken)) {
//		UserDetails userDetail = (UserDetails) auth.getPrincipal();	
//		model.addObject("username", userDetail.getUsername());
//	  }
//		
//	  model.setViewName("403");
//	  return model;
//
//	}
    
}
