package ru.innopolis.course.java2016.girevoy.lessons.lesson27.Calculator;

import ru.innopolis.course.java2016.girevoy.lessons.lesson27.Calculator.commands.Command;
import ru.innopolis.course.java2016.girevoy.lessons.lesson27.Calculator.commands.exeptions.CommandExeption;
import ru.innopolis.course.java2016.girevoy.lessons.lesson27.Calculator.exeptions.CalculatorExeption;
import ru.innopolis.course.java2016.girevoy.lessons.lesson27.ChainEllement;
import ru.innopolis.course.java2016.girevoy.lessons.lesson27.ChainEllementExeption;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Girevoy.T on 08.11.2016.
 */
public class Calculator extends ChainEllement{
	Map<String,Command> commandMap = new HashMap<>();

	/**
	 * Метод добавляет команду к калькулятору
	 * @param str команда консоли
	 * @param command реализация команды
	 */
	public void addCommand(String str,Command command) {
		commandMap.put(str,command);
	}

	/**
	 * Метод выполняющий определенную команду в зависимости от строки
	 * @param command команда
	 * @param args аргументы
	 * @return
	 * @throws CalculatorExeption
	 */
	public Number countUp(String command,Number[] args) throws CalculatorExeption {
		Number result = null;
		try {
		for (String key: commandMap.keySet()) {
			if (key.equals(command)) {
				result = commandMap.get(key).execute(args);
			}
		}
		} catch (CommandExeption e) {
			throw new CalculatorExeption("Ошибка выполнения комманды",e);
		}
		if (result == null) {
			throw new CalculatorExeption("Такое действие не задано");
		}
		return result;
	}

	@Override
	protected Object doWork(Object msg) throws ChainEllementExeption {
		Object result;
		if (!(msg instanceof String[])) {
			throw new ChainEllementExeption("Неверное входящее сообщение");
		} else if (((String[])msg).length != 3) {
			throw new ChainEllementExeption("Неверное входящее сообщение");
		} else {
			String[] splitString = (String[])msg;
			Number[] argsForCalculator = new Number[splitString.length-1];
			for (int i =1; i < splitString.length;i++) {
				argsForCalculator[i-1] = Double.parseDouble(splitString[i]);
			}
			try {
				result = countUp(splitString[0],argsForCalculator);
			} catch (CalculatorExeption e) {
				throw new ChainEllementExeption("Ошибка калькулятора",e);
			}
		}
		return result;
	}
}
