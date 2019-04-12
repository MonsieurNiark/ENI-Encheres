package fr.eni.encheres.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import fr.eni.encheres.bll.ArticleVenduManager;
import fr.eni.encheres.bll.EnchereManager;
import fr.eni.encheres.bll.UtilisateurManager;

public class EnchereListener implements ServletContextListener{
    private Thread t = null;
    private ServletContext context;
    public void contextInitialized(ServletContextEvent contextEvent) {
    	UtilisateurManager umgt = new UtilisateurManager();
    	ArticleVenduManager amgt = new ArticleVenduManager();
    	EnchereManager emgt = new EnchereManager();
    	
        t =  new Thread(){
            //task
            public void run(){                
                try {
                    while(true){
                        System.out.println("________________");
                        Thread.sleep(10000);
                    }
                } catch (InterruptedException e) {}
            }            
        };
        t.start();
        context = contextEvent.getServletContext();
        // you can set a context variable just like this
        context.setAttribute("TEST", "TEST_VALUE");
    }
    public void contextDestroyed(ServletContextEvent contextEvent) {
        // context is destroyed interrupts the thread
        t.interrupt();
    }         

}
