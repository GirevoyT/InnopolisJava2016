package ru.innopolis.course.java2016.girevoy.lessons.lesson5.testHappensBefour;

import ru.innopolis.course.java2016.girevoy.lessons.lesson5.testHappensBefour.items.Box;
import ru.innopolis.course.java2016.girevoy.lessons.lesson5.testHappensBefour.threads.BigChronoCheckThread;
import ru.innopolis.course.java2016.girevoy.lessons.lesson5.testHappensBefour.threads.ChronoThread;

/**
 * Created by masterlomaster on 07.10.16.
 */
public class TestHappensBefour {
	public static void main(String[] args) {
		Box counter = new Box(0);
		ChronoThread chronoThread = new ChronoThread(counter);
		BigChronoCheckThread bigChronoCheckThread5 = new BigChronoCheckThread(counter, 5);
		BigChronoCheckThread bigChronoCheckThread7 = new BigChronoCheckThread(counter, 7);
		chronoThread.start();
		bigChronoCheckThread5.start();
		bigChronoCheckThread7.start();
	}
}
