package com.freecharge.problem.wordcount.services;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import com.freecharge.problem.wordcount.config.FolderConfig;


public class WordCountServiceInitiator {

     public static void main(String[] args) throws Exception {
    	 
    	 if(args.length > 1 || args.length < 1){
    		 System.out.println("Argument can only be a FileName or FolderName\n If Multiple Files need to be added those to a Folder ");
    	 }
    	 
    	 FolderConfig.getInstance().setFolderName(args[0]);
    	 
    	 ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
         context.setContextPath("/");
  
         Server jettyServer = new Server(8080);
         jettyServer.setHandler(context);
  
         ServletHolder jerseyServlet = context.addServlet(
              org.glassfish.jersey.servlet.ServletContainer.class, "/*");
         jerseyServlet.setInitOrder(0);
  
         // Tells the Jersey Servlet which REST service/class to load.
         jerseyServlet.setInitParameter(
            "jersey.config.server.provider.classnames",
            com.freecharge.problem.wordcount.resources.SearchWordService.class.getCanonicalName());
  
         try {
             jettyServer.start();
             jettyServer.join();
         } finally {
             jettyServer.destroy();
         }
      }
}
