package by.senla.zartem.foodpricemonitoring.app;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext appContext =
				new AnnotationConfigWebApplicationContext();
		
		appContext.register(AppConfig.class, JPAConfig.class, SecurityConfig.class);
		
		servletContext.addListener(new ContextLoaderListener(appContext));
		
		appContext.setServletContext(servletContext);
		
		ServletRegistration.Dynamic servlet =
				servletContext.addServlet("dispatcher", new DispatcherServlet(appContext));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
	}

}
