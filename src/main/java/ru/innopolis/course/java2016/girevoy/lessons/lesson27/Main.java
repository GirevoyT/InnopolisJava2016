package ru.innopolis.course.java2016.girevoy.lessons.lesson27;

import lombok.extern.slf4j.Slf4j;
import ru.innopolis.course.java2016.girevoy.lessons.lesson27.Calculator.Calculator;
import ru.innopolis.course.java2016.girevoy.lessons.lesson27.Calculator.CalculatorBuilder;
import ru.innopolis.course.java2016.girevoy.lessons.lesson27.Calculator.commands.AddCommand;
import ru.innopolis.course.java2016.girevoy.lessons.lesson27.Calculator.commands.SubCommand;
import ru.innopolis.course.java2016.girevoy.lessons.lesson27.Calculator.exeptions.CalculatorExeption;

import java.util.Scanner;

/**
 * Created by Girevoy.T on 08.11.2016.
 */
@Slf4j
public class Main {
	public static void main(String[] args) {
		log.info("Success");

		Calculator calculator = (new CalculatorBuilder())
			.addCommand("add",new AddCommand())
			.addCommand("sub",new SubCommand())
			.build();

		Scanner scanner = new Scanner(System.in);
		inf:
		while (true) {
			System.out.println("Ready for input");;
			String command = scanner.nextLine();
			String[] splitString = command.split(" ");
			switcher:
			switch (splitString[0]) {
				case "help" :
					System.out.println("ПОМОЩЬ");
					break switcher;
				case "exit" :
					break inf;
				default:
					Number[] argsForCalculator = new Number[splitString.length-1];
					for (int i =1; i < splitString.length;i++) {
						argsForCalculator[i-1] = Double.parseDouble(splitString[i]);
					}
					try {
						System.out.println(calculator.countUp(splitString[0],argsForCalculator));
					} catch (CalculatorExeption calculatorExeption) {
						calculatorExeption.printStackTrace();
					}
			}
		}
	}
}
