package ru.innopolis.course.java2016.girevoy.lessons.lesson27;

import ru.innopolis.course.java2016.girevoy.lessons.lesson27.Calculator.CalculatorBuilder;
import ru.innopolis.course.java2016.girevoy.lessons.lesson27.Calculator.commands.AddCommand;
import ru.innopolis.course.java2016.girevoy.lessons.lesson27.Calculator.commands.SubCommand;
import ru.innopolis.course.java2016.girevoy.lessons.lesson27.otherChainElements.BannerEllement;
import ru.innopolis.course.java2016.girevoy.lessons.lesson27.otherChainElements.DataBaseEllement;
import ru.innopolis.course.java2016.girevoy.lessons.lesson27.otherChainElements.SoutNumberEllement;

/**
 * Created by Girevoy.T on 08.11.2016.
 */
public class ActionChain {
	private static final ActionChain INSTANCE;
	private ChainEllement root;

	static {
		INSTANCE = new ActionChain();
	}

	public static ActionChain getInstance() {
		return INSTANCE;
	}

	private ActionChain(){
		root = new BannerEllement();

		ChainEllement curr = root;
		ChainEllement next;

		next = new DataBaseEllement();
		curr.setNext(next);
		curr = next;

		next = (new CalculatorBuilder())
				.addCommand("add",new AddCommand())
				.addCommand("sub",new SubCommand())
				.build();;
		curr.setNext(next);
		curr = next;

		next = new SoutNumberEllement();
		curr.setNext(next);
	};

	public void start(String command) throws TimeToBreakExeption {
		String[] splitString = command.split(" ");
		switcher:
		switch (splitString[0]) {
			case "help" :
				System.out.println("ПОМОЩЬ");
				break switcher;
			case "exit" :
				throw new TimeToBreakExeption();
			default:
				try {
					root.start(splitString);
				} catch (ChainEllementExeption chainEllementExeption) {
					chainEllementExeption.printStackTrace();
				}
		}
	}
}
