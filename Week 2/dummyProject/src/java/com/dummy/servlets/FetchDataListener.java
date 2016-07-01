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
           System.out.println(userList.size());
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
