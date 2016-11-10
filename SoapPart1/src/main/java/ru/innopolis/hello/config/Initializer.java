package ru.innopolis.hello.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


@ComponentScan ("ru.innopolis.hello")
@EnableAutoConfiguration
public class Initializer implements WebApplicationInitializer {

	// Указываем имя нашему Servlet Dispatcher для мапинга
	private static final String DISPATCHER_SERVLET_NAME = "dispatcher";

	public MessageDispatcherServlet dispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return servlet;
	}
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();

		// Регистрируем в контексте конфигурационный класс, который мы создадим ниже
		ctx.register(WebServicesConfig.class);

		servletContext.addListener(new ContextLoaderListener(ctx));

		ctx.setServletContext(servletContext);

		ServletRegistration.Dynamic servlet = servletContext.addServlet(DISPATCHER_SERVLET_NAME,
			dispatcherServlet(ctx));
		servlet.addMapping("/ws/*");
		servlet.setLoadOnStartup(1);
	}

}