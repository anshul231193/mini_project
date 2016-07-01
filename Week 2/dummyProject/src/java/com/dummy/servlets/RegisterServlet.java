/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dummy.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author anshul
 */

@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    //Collection of Users
    HashSet<User> userCollection;
    
    //initialization of Servlet
    public void init() throws ServletException {
        ServletContext application = getServletConfig().getServletContext();
        userCollection = (HashSet<User>) application.getAttribute("listUsers");
        System.out.println(userCollection.size());
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        RequestDispatcher dispatcher = getServletContext().
                getRequestDispatcher("/register.jsp");
        dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String userName = request.getParameter("usrname");
        String pswd = request.getParameter("pwd");
        String email = request.getParameter("email");
        String mobile = request.getParameter("phone");
        if(userCollection.size() != 0) {
            Iterator userItr = userCollection.iterator();
            while(userItr.hasNext()) {
                User user = (User)userItr.next();
                System.out.println(user.getUserName());
                if(user.getUserName().equals(userName)) {
                    response.setHeader("Refresh", "5; URL=register");
                    throw new ServletException("User Already Registered");
                }
            }
            User newUser = new User(name,userName,pswd,email,mobile);
                   userCollection.add(newUser);
        }
        else {
            User user = new User(name,userName,pswd,email,mobile);
            userCollection.add(user);
        }
        System.out.println(userCollection.size());
        PrintWriter out = response.getWriter();
        out.println("        <link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\"><div class=\"alert alert-success\" id=\"register\">\n" +
"            <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>\n" +
"            <strong>Success!</strong> Successfully registered, You will be soon redirected to login page.\n" +
"        </div>");
        response.setHeader("Refresh", "5; URL=index");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
