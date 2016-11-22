package ru.innopolis.adressbook.web.configs;


import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class Initializer implements WebApplicationInitializer {
	// Указываем имя нашему деспетчеру сервлетов
	private static final String DISPATCHER_SERVLET_NAME = "dispatcher";
	// Указываем имя нашему security фильтру
	private static final String SPRING_SECURITY_FILTER_CHAIN = "dispatcher";


	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		// Регистрация конфигов
		ctx.register(WebMvcConfig.class);
		ctx.register(AppContext.class);
		ctx.register(SecurityContext.class);

		//Добавление нового слушателя контекста (контекст в который все будет записываться)
		servletContext.addListener(new ContextLoaderListener(ctx));

		ctx.setServletContext(servletContext);

		//Создание диспетчера сервлетов
		ServletRegistration.Dynamic servlet = servletContext.addServlet(DISPATCHER_SERVLET_NAME,
			new DispatcherServlet(ctx));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);

//		//Создание фильтра для spring security
//		final FilterRegistration.Dynamic securityFilter = servletContext.addFilter(SPRING_SECURITY_FILTER_CHAIN
//			, new DelegatingFilterProxy());
//		securityFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
//		securityFilter.setAsyncSupported(true);
	}
}
