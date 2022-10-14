package com.revature.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import java.time.LocalDateTime;

import com.revature.servlets.TestServlet; //I like to import external libs on top, own packages next

public class ContextListener implements ServletContextListener { //I WAS LITERALLY WORKING UNTIL I ADDED THIS CONTEXT LISTENER!
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("[LOG] - The servlet context was initialized at " + LocalDateTime.now());

        // We can also programmatically define/register our servlets with the container here

        //ObjectMapper mapper = new ObjectMapper();

        TestServlet testServlet = new TestServlet();


        // Now I need to register it with the context itself
        ServletContext context = sce.getServletContext();
        ServletRegistration.Dynamic registeredServlet = context.addServlet("TestServlet", testServlet);
        // Now I can affect the fields that I wanted to before
        registeredServlet.addMapping("/tests");
        registeredServlet.setLoadOnStartup(3);
        registeredServlet.setInitParameter("test-servlet-key", "test-servlet-value");
        registeredServlet.setInitParameter("another-param", "another-value");

        /*
        ExampleServlet exampleServlet = new ExampleServlet(mapper);
        context.addServlet("ExampleServlet", exampleServlet).addMapping("/examples");
         */

        // Register the servlet
//        context.addServlet("FlashcardServlet", flashcardServlet).addMapping("/flashcards/*");
//        context.addServlet("AuthServlet", authServlet).addMapping("/auth");
        context.addServlet("TestServlet", testServlet).addMapping("/test");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("[LOG] - The servlet context was destroyed at " + LocalDateTime.now());
    }
}
