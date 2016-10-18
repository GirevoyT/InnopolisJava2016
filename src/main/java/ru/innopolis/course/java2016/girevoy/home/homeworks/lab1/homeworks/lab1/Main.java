package ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.homeworks.lab1;

import ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.homeworks.lab1.devourers.Devourer;
import ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.homeworks.lab1.logica.Logica;
import ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.homeworks.lab1.logica.MyTaskIntegerLogica;
import ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.homeworks.lab1.resource.Resource;
import ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.homeworks.lab1.resource.SafetyFileResource;

/**
 * Created by Arxan on 08.10.2016.
 */
public class Main {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Start!");
		SafetyFileResource resource1 = new SafetyFileResource("./src/Resource1");
		Resource<Integer> resource2 = new SafetyFileResource("./src/Resource2");
		Logica<Integer> myLogica1 = new MyTaskIntegerLogica();
		Logica<Integer> myLogica2 = new MyTaskIntegerLogica();
		DeepThought deepThought1 = new DeepThought(myLogica1);
		DeepThought deepThought2 = new DeepThought(myLogica2);
		Devourer devourer1 = new Devourer(resource1,deepThought1);
		Devourer devourer2 = new Devourer(resource2,deepThought1);
		Devourer devourer3 = new Devourer(resource2,deepThought2);
	}
}
