package ru.innopolis.course.java2016.girevoy.lessons.lesson6.testProxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by masterlomaster on 10.10.16.
 */
public class HumanImpl implements Human, HumanAdress {
	private int age;
	private String name;
	private String adress;

	public static Object createHuman() {
		ClassLoader classLoader = MainTestProxy2.class.getClassLoader();
		InvocationHandler invocationHandler = new InvocationHandler() {
			HumanImpl human = new HumanImpl();
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Object result = method.invoke(human,args);
				return result;
			}
		};
		return  Proxy.newProxyInstance(classLoader,new Class[]{Human.class,HumanAdress.class},invocationHandler);
	}

	@Override
	public int getAge() {
		return age;
	}

	@Override
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getAdress() {
		return adress;
	}

	@Override
	public void setAdress(String adress) {
		this.adress = adress;
	}
}
