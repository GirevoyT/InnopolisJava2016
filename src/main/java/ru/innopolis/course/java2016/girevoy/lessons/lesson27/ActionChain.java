package ru.innopolis.course.java2016.girevoy.lessons.lesson27;

/**
 * Created by Girevoy.T on 08.11.2016.
 */
public class ActionChain {
	private static final ActionChain INSTANCE;
	private ChainEllement root;

	static {
		INSTANCE = new ActionChain();

	}

	private ActionChain(){};

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
				Number[] argsForCalculator = new Number[splitString.length-1];
				for (int i =1; i < splitString.length;i++) {
					argsForCalculator[i-1] = Double.parseDouble(splitString[i]);
				}
				root.start(splitString);
		}
	}
}
