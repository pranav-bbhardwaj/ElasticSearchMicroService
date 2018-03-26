package org.testmicro.analytics.service;

import java.net.URL;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.testmicro.analytics.common.Constants;
import org.testmicro.injection.guice.ServiceGuice;


public class AnalyticsServiceContextListener implements ServletContextListener{ 

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO cleanup
		
	}
	
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
		//read properties 
		Properties properties = loadProperties();
		// init service
		ServiceGuice.init(properties);
		
	}
	
	private Properties loadProperties() {
		Properties props = new Properties();
	
		try {
	
			URL url = getClass().getResource("/" + Constants.PROPERTIES_FILE_NAME);
	        props.load(url.openStream());
	        
	
		} catch(Exception ex) {
			String errMsg = "unable to load properties :";
			System.out.println(errMsg + ex);
			throw new RuntimeException(ex);
		}
		return props;
	}
}


