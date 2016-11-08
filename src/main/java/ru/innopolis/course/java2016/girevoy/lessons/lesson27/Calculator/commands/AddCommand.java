package ru.innopolis.course.java2016.girevoy.lessons.lesson27.Calculator.commands;

import ru.innopolis.course.java2016.girevoy.lessons.lesson27.Calculator.commands.exeptions.CommandExeption;

/**
 * Created by Girevoy.T on 08.11.2016.
 */
public class AddCommand implements Command {
	@Override
	public Number execute(Number[] args) throws CommandExeption {
		if (args.length != 2) {
			throw new CommandExeption("Неверное колличество аргументов");
		}
		Number result = args[0].doubleValue() + args[1].doubleValue();
		return result;
	}
}
