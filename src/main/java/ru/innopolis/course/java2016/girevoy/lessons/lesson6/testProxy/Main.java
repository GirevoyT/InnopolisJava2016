package ru.innopolis.course.java2016.girevoy.lessons.lesson6.testProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by masterlomaster on 10.10.16.
 */
public class Main {
	public static void main(String[] args) {
		Object obj = new Object();

		FirstInterface firstInterface = new FirstInterface() {
			@Override
			public void firstPrint() {
				System.out.println("First Print Anonim");
			}
		};
		firstInterface.firstPrint();

		FirstInterface proxy = (FirstInterface) Proxy.newProxyInstance(Main.class.getClassLoader(), new Class[]{FirstInterface.class,SecondInterface.class}, new InvocationHandler() {
			SuperClass superClass = new SuperClass();
			@Override
			public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
				System.out.println("Перехват " + method.getName());
				method.invoke(superClass,objects);
				return null;
			}
		});

		proxy.firstPrint();
		((SecondInterface)proxy).secondPrint();
	}
}
