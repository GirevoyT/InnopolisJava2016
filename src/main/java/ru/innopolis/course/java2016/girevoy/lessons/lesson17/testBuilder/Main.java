package ru.innopolis.course.java2016.girevoy.lessons.lesson17.testBuilder;

/**
 * Created by oem on 25.10.16.
 */
public class Main {
	public static void main(String[] args) {
		ComputerBuildManager manager = new ComputerBuildManager(new IntelComputerBuilder());
		Computer computer = manager.build();
		System.out.println(computer);
	}
}
