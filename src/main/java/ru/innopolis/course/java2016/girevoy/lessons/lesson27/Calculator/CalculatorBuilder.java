package ru.innopolis.course.java2016.girevoy.lessons.lesson27.Calculator;

import ru.innopolis.course.java2016.girevoy.lessons.lesson27.Calculator.commands.Command;

/**
 * Created by Girevoy.T on 08.11.2016.
 */
public class CalculatorBuilder {
	protected Calculator calculator = new Calculator();

	/**
	 * Первая команда билдера которая создаёт объект калькулятор
	 * @return
	 */
	public Calculator build()  {
		return this.calculator;
	}

	/**
	 * Команда которая добавляет к строящемуся калькулятору команду
	 * @param commandString команда консоли
	 * @param command реализация команды
	 * @return
	 */
	public CalculatorBuilder addCommand(String commandString,Command command) {
		calculator.addCommand(commandString,command);
		return this;
	}
}
