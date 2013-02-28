package br.com.fiap.samf.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class EMF implements ServletContextListener {

	private static EntityManagerFactory emf;

    public void contextInitialized(ServletContextEvent arg0) {
    	System.out.println("inicio do acesso ao banco");  
    	emf = Persistence.createEntityManagerFactory("SAMF");
    }

    public void contextDestroyed(ServletContextEvent arg0) {
    	 if (emf != null) {
    		 System.out.println("fim do acesso ao banco"); 
    		 emf.close();
    	 }
    }
    
    public static EntityManager createEntityManager() {
        if (emf == null) {
            throw new IllegalStateException("Context is not initialized yet.");
        }
        return emf.createEntityManager();
    }
	
}
