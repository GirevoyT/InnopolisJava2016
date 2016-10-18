package ru.innopolis.course.java2016.girevoy.lessons.lesson6.testProxy;

/**
 * Created by masterlomaster on 10.10.16.
 */
public class SuperClass implements FirstInterface,SecondInterface {
	@Override
	public void firstPrint() {
		System.out.println("First print");
	}

	@Override
	public void secondPrint() {
		System.out.println("Second print");
	}
}
