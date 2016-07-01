/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dummy.servlets;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author anshul
 */
public class FetchDataListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
        System.out.println("Project Deployed");
        ServletContext application = sce.getServletContext();
     
        HashSet<User> userCollection = new HashSet<User>();
        
        if(application.getAttribute("listUsers") == null) {
            try
            {
               FileInputStream fileIn = new FileInputStream("/home/anshul/miniProject/Week 2/dummyProject/web/user.ser");
               ObjectInputStream in = new ObjectInputStream(fileIn);
               System.out.println(userCollection.size());
               userCollection = (HashSet<User>) in.readObject();
               in.close();
               fileIn.close();
               System.out.println(userCollection.size());
            }catch(IOException i)
            {
                i.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FetchDataListener.class.getName()).log(Level.SEVERE, null, ex);
            }
            application.setAttribute("listUsers", userCollection);
        } else {
            userCollection = (HashSet<User>) application.getAttribute("listUsers");
        }
     
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Project Undeployed");
        ServletContext application = sce.getServletContext();
        HashSet<User> userList = (HashSet<User>) application.getAttribute("listUsers");
        try
        {
           FileOutputStream fileOut = new FileOutputStream("/home/anshul/miniProject/Week 2/dummyProject/web/user.ser");
           ObjectOutputStream out = new ObjectOutputStream(fileOut);
           out.writeObject(userList);
           out.close();
           fileOut.close();
           System.out.println(userList.size());
           System.out.println("Serialized data is saved in user.ser");
        }catch(IOException i)
        {
            i.printStackTrace();
        }
    }
    
}
