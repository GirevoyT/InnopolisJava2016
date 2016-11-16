package ru.innopolis.server.models;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import ru.innopolis.common.models.student.StudentService;
import ru.innopolis.server.models.student.StudentServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Girevoy.T on 15.11.2016.
 */
@Slf4j
public class ServiceLogger implements InvocationHandler {

	@Autowired
	private ApplicationContext appContext;


	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		StudentServiceImpl studentService2 = new StudentServiceImpl();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
			.getAuthentication().getPrincipal();
		log.info("Выполнен метод {} пользователем {}",method.getName(),userDetails.getUsername());
		method.invoke(studentService2,args);
		return null;
	}
}
