package com.socialhub.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.DispatcherServlet;
/*
 * Esta clase reemplaza al archivo web.xml
 * Aqui se configuran las cosas basicas para que corra nuestra aplicacion.
 * */
public class WebInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(WebAppConfig.class);
		ctx.setServletContext(servletContext);
		servletContext.addListener(new ContextLoaderListener(ctx));
		registerHiddenFieldFilter(servletContext);
		Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
		//servlet.setInitParameter("contextConfigLocation", "/WEB-INF/spring/appServlet/servlet-context.xml");
		servlet.addMapping("/");
		servlet.addMapping("/resources/*");
		/*servlet.addMapping("*.css");
		servlet.addMapping("*.js");*/
		servlet.setLoadOnStartup(1);
	}
	
	private void registerHiddenFieldFilter(ServletContext aContext) {
        aContext.addFilter("hiddenHttpMethodFilter", new     HiddenHttpMethodFilter()).addMappingForUrlPatterns(null ,true, "/*"); 
    }

}
