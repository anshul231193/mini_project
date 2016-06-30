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
@WebServlet(name = "DeleteServlet", urlPatterns = {"/deleteAddress"})
public class DeleteServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);
        if(session.getAttribute("user") == null) {
            response.sendRedirect("index");
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
        String[] values = request.getParameterValues("addressList");
        HashSet<Integer> addrList = new HashSet<Integer>();
        for(int i=0;i<values.length;i++) {
            addrList.add(Integer.parseInt(values[i]));
        }
        PrintWriter out = response.getWriter();
        out.println("<link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\"><div class=\"alert alert-success\" id=\"register\">\n" +
"            <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>\n" +
"            <strong>Success!</strong> Successfully deleted, You will be soon redirected to login page.\n" +
"        </div>");
        deleteAddress(addrList, request, response );
        response.setHeader("Refresh","3; URL=home");
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

    private void deleteAddress(HashSet<Integer> addrList,HttpServletRequest request, 
            HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        ServletContext application = getServletConfig().getServletContext();
        HashSet<User> userCollection = (HashSet<User>) application.
                getAttribute("listUsers");
        for (Iterator<User> i = userCollection.iterator(); i.hasNext();) {
            User newUser = i.next();
            if (newUser.getUserName().equals(user.getUserName())) {
                HashSet<Address> adr = newUser.address;
                for (Iterator<Address> j = adr.iterator(); j.hasNext();) {
                    Address newAdr = j.next();
                    if (addrList.contains(newAdr.getId())) {
                        j.remove();
                    }
                }
            }
        }
    }
}


