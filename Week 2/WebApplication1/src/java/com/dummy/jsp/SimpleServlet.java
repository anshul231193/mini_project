/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dummy.jsp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author anshul
 */
@WebServlet("/home")
public class SimpleServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
                                                    throws ServletException, 
                                                                      IOException {
        
        String name = req.getParameter("name");
        if(name != null) {
            resp.getWriter().printf("Hello %s",name);
        } else {
            resp.getWriter().write("Please enter valid name");
        }
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
                                                    throws ServletException, 
                                                                      IOException {
        
        String name = req.getParameter("name");
        if(name != null) {
            resp.getWriter().printf("Hello %s",name);
        } else {
            resp.getWriter().write("Please enter valid name");
        }
    }
    
}
