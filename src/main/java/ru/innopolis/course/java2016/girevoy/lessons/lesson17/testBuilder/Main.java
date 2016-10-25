package ru.innopolis.course.java2016.girevoy.lessons.lesson17.testBuilder;

/**
 * Created by oem on 25.10.16.
 */
public class Main {
	public static void main(String[] args) {
//		ComputerBuildManager manager = new ComputerBuildManager(new IntelComputerBuilder());
//		Computer computer = manager.build();
//		System.out.println(computer);
		Computer computer = new Computer.Builder()
				.withMotherboard("1")
				.withProcessor("2")
				.withMemory("3")
				.withOS("4").build();
		System.out.println(computer);
	}
}
