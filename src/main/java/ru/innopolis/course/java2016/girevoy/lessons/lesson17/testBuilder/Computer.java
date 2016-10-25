package ru.innopolis.course.java2016.girevoy.lessons.lesson17.testBuilder;

/**
 * Created by oem on 25.10.16.
 */
public class Computer {
	private final String motherBoard;
	private final String processor;
	private final String memory;
	private final String os;

	private Computer (Builder builder) {
		this.motherBoard = builder.motherBoard;
		this.processor = builder.processor;
		this.memory = builder.memory;
		this.os = builder.os;
	}


	public String getMotherBoard() {
		return motherBoard;
	}



	public String getProcessor() {
		return processor;
	}


	public String getMemory() {
		return memory;
	}



	public String getOs() {
		return os;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(processor).append(" ").append(memory).append(" ").append(os);
		return stringBuilder.toString();
	}

	public static class Builder {
		private String motherBoard;
		private String processor;
		private String memory;
		private String os;

		public Builder withMotherboard( String motherBoard) {
			this.motherBoard = motherBoard;
			return this;
		}

		public Builder withProcessor( String processor) {
			this.processor = processor;
			return this;
		}
		public Builder withMemory( String memory) {
			this.memory = memory;
			return this;
		}
		public Builder withOS( String os) {
			this.os = os;
			return this;
		}

		public Computer build() {
			return new Computer(this);
		}
	}
}
