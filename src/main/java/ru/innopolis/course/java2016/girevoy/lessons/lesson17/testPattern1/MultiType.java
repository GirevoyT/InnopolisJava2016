package ru.innopolis.course.java2016.girevoy.lessons.lesson17.testPattern1;

/**
 * Created by oem on 25.10.16.
 */
public class MultiType implements FirstInterface,SecondInterface {
	FirstInterface delegateFirstInterface = new FirstImpl();
	SecondInterface delegateSecondInterface = new SecondImpl();
	@Override
	public void doSomeFirst() {
		delegateFirstInterface.doSomeFirst();
	}

	@Override
	public void doSomeSecond() {
		delegateSecondInterface.doSomeSecond();
	}
}
