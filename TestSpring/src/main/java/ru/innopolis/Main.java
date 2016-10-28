package ru.innopolis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Girevoy.T on 28.10.2016.
 */
public class Main {
	public static void main(String[] args) {
		System.out.println("Success");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"text.xml"});
		String tmpmsg = "Bamboleilo";
		TmpClass tmpClass = (TmpClass) applicationContext.getBean("aksjhd",new Object[]{null,"asd"});
	}

}
