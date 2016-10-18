package ru.innopolis.course.java2016.girevoy.lessons.lesson8.HelloWorld;

import org.apache.log4j.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by masterlomaster on 12.10.16.
 */
public class HelloWorld {
	private static Logger logger = LoggerFactory.getLogger(HelloWorld.class);
	public static void main(String[] args) {
		try {
			String userName = getUserName();
			MDC.put("userName",userName);
			MDC.put("userRole","admin");
		} finally {
			MDC.clear();
		}

		doSomething();
	}

	private static void doSomething() {
		logger.error("error Test");
		logger.info("info Test");
		logger.debug("debugg Test");
		logger.trace("trace Test");
	}

	private static String getUserName() {
		return  "Test User Name";
	}

}
