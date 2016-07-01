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
@WebServlet(name = "AddressServlet", urlPatterns = {"/addEditAddress"})
public class AddressServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    int addressId;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);
        if(session.getAttribute("user") == null) {
                response.sendRedirect("index");
        } else {
            if(request.getParameter("id") != null) {
                addressId = Integer.parseInt(request.getParameter("id"));
                displayValuesForm(request,response,session,addressId);
            } else {
            RequestDispatcher dispatcher = getServletContext().
                    getRequestDispatcher("/addEditAddress.jsp");
            dispatcher.forward(request, response);
            }
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
        
        int id = (int) application.getAttribute("uniqueId");
        id++;
        application.setAttribute("uniqueId", id);
        String street = request.getParameter("street");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String country = request.getParameter("country");
        Address address = new Address(id,street,city,state,country);
        HttpSession session = request.getSession(false);
        addAddress(address,session);
        addAddress(address, session, addressId, response);
        PrintWriter out = response.getWriter();
        out.println("<link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\"><div class=\"alert alert-success\" id=\"register\">\n" +
"            <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>\n" +
"            <strong>Success!</strong> Successfully added, You will be soon redirected to login page.\n" +
"        </div>");
        response.setHeader("Refresh", "3;URL=home");
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

    private void addAddress(Address address,HttpSession session) {
        User user = (User) session.getAttribute("user");
        ServletContext application = getServletConfig().getServletContext();
        HashSet<User> userCollection = (HashSet<User>) application.
                getAttribute("listUsers");
        if(userCollection == null) {
            userCollection = new HashSet<User>();
        }
        Iterator userItr = userCollection.iterator();
        while(userItr.hasNext()) {
            User newUser = (User)userItr.next(); 
            if(newUser.getUserName().equals(user.getUserName())) {
                   newUser.address.add(address);
                   userCollection.add(newUser);
            }
        }
    }

    private void displayValuesForm(HttpServletRequest request, HttpServletResponse response,
            HttpSession session, int addressId) throws ServletException, IOException {
        User user = (User)session.getAttribute("user");
        HashSet<Address> listAddress = user.address;
        Iterator itrAddr = listAddress.iterator();
        
        while(itrAddr.hasNext()) {
            Address adr = (Address)itrAddr.next();
            if(adr.getId() == addressId) {
                RequestDispatcher dispatcher = getServletContext().
                    getRequestDispatcher("/addEditAddress.jsp");
            request.setAttribute("address", adr);
            dispatcher.forward(request, response);
            }
        }
    }

    private void addAddress(Address address, HttpSession session, int addressId,
            HttpServletResponse response) {
        User user = (User) session.getAttribute("user");
        ServletContext application = getServletConfig().getServletContext();
        HashSet<User> userCollection = (HashSet<User>) application.
                getAttribute("listUsers");
        Iterator userItr = userCollection.iterator();
        for (Iterator<User> i = userCollection.iterator(); i.hasNext();) {
            User newUser = i.next();
            if (newUser.getUserName().equals(user.getUserName())) {
                HashSet<Address> adr = newUser.address;
                for (Iterator<Address> j = adr.iterator(); j.hasNext();) {
                    Address newAdr = j.next();
                    if(newAdr.getId() == addressId) {
                        j.remove();
                        adr.add(address);
                        response.setHeader("Refresh","3; URL=home");
                    }
                }
            }
        }
    }

}
