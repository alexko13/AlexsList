package utility;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import models.Listing;

public class Initializer implements ServletContextListener {
    public static final String LISTINGS_ATTRIBUTE = "listings";
    
    public void contextInitialized(ServletContextEvent sce){
        List<Listing> listings = new ArrayList<Listing>();

        sce.getServletContext().setAttribute(LISTINGS_ATTRIBUTE, listings);
    }

    public void contextDestroyed(ServletContextEvent sce){
    	sce.getServletContext().removeAttribute(LISTINGS_ATTRIBUTE);
    }
}

