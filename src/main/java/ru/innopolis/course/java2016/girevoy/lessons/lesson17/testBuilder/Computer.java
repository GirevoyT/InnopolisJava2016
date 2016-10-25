package ru.innopolis.course.java2016.girevoy.lessons.lesson17.testBuilder;

/**
 * Created by oem on 25.10.16.
 */
public class Computer {
	private String motherBoard;
	private String processor;
	private String memory;
	private String os;

	public String getMotherBoard() {
		return motherBoard;
	}

	public void setMotherBoard(String motherBoard) {
		this.motherBoard = motherBoard;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public String getOs() {
		return os;
	}

	public void setOS(String os) {
		this.os = os;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(processor).append(" ").append(memory).append(" ").append(os);
		return stringBuilder.toString();
	}
}
