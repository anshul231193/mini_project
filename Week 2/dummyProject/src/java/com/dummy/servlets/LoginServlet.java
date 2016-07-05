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
import javax.servlet.http.HttpSession;

/**
 *
 * @author anshul
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/index"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    //unique Global Id for Address
    int uniqueId;
    
    public void init() throws ServletException {
        uniqueId = 0;
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        generateUniqueId();
        HttpSession session = request.getSession(false);
        if(session.getAttribute("user") != null) {
            response.sendRedirect("home");
        } else {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }
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
        ServletContext application = getServletConfig().getServletContext();
        HashSet<User> userCollection;
        HttpSession session;
        
        if(application.getAttribute("listUsers") == null) {
            userCollection = new HashSet<User>();
        }
        else {
            userCollection = (HashSet<User>) application.getAttribute("listUsers");
        }
        String userName = request.getParameter("username");
        String pswd = request.getParameter("password");
        if(userCollection.size() != 0) {
            int flag = 0;
            Iterator userItr = userCollection.iterator();
            while(userItr.hasNext()) {
                User user = (User)userItr.next();
                System.out.println(user.getUserName()+ " "+user.getPswd());
                if(user.getUserName().equals(userName) &&
                                        user.getPswd().equals(pswd)) {
                    flag = 1;
                    session = request.getSession(true);
                        session.setAttribute("user", user);
                    response.sendRedirect("home");
//                    response.setHeader("Refresh", "0; URL=home.jsp");
                }
            }
            if(flag == 0) {
                response.setHeader("Refresh", "5; URL=index");
                throw new ServletException("Invalid Username or Password");
            }
        }
        else {
            response.setHeader("Refresh", "5; URL=index");
            throw new ServletException("Register First");
        }
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

    private void generateUniqueId() {
        ServletContext application = getServletConfig().getServletContext();
        application.setAttribute("uniqueId", uniqueId);
    }

}
