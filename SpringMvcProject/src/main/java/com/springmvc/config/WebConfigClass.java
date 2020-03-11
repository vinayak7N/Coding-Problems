package com.springmvc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebConfigClass{ //implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		
		System.out.println("WebConfigClass startup called...............");

		// Creating WebApplicationContext which will provide dispatcher servlet configuration using xml
		
//		XmlWebApplicationContext webApplicationContext = new XmlWebApplicationContext();
//		webApplicationContext.setConfigLocation("classpath:application-config.xml");

		// Creating WebApplicationContext which will provide dispatcher servlet configuration using Java config
		
		AnnotationConfigWebApplicationContext webApplicationContext=new AnnotationConfigWebApplicationContext();
		webApplicationContext.register(AppConfig.class);
		
		// Creating dispatcher servlet
		DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);

		// Registring dispatcher servlet with servlet context
		Dynamic addServlet = servletContext.addServlet("dispatcher", dispatcherServlet);
		addServlet.setLoadOnStartup(1);
		addServlet.addMapping("/");

	}

}
