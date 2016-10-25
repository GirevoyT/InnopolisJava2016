package ru.innopolis.course.java2016.girevoy.lessons.lesson17.testBuilder;

/**
 * Created by oem on 25.10.16.
 */
public abstract class AbstractComputerBuilder {
	protected Computer computer;
	public AbstractComputerBuilder createNewComputer() {
		this.computer = new Computer();
		return this;
	}
	public Computer getComputer() {
		return this.computer;
	}
	public abstract AbstractComputerBuilder setMotherBoard();
	public abstract AbstractComputerBuilder setProcessor();
	public abstract AbstractComputerBuilder setMemory();
	public abstract AbstractComputerBuilder setOS();

}
