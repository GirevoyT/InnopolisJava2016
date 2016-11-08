package ru.innopolis.course.java2016.girevoy.lessons.lesson27.Calculator.commands;

import ru.innopolis.course.java2016.girevoy.lessons.lesson27.Calculator.commands.exeptions.CommandExeption;

/**
 * Created by Girevoy.T on 08.11.2016.
 */
public interface Command {
	/**
	 * Метод для выполнения команды
	 * @param args аргументы
	 * @return
	 */
	Number execute(Number[] args) throws CommandExeption;
}
