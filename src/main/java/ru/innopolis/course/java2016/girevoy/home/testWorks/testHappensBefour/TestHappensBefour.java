package ru.innopolis.course.java2016.girevoy.home.testWorks.testHappensBefour;

import ru.innopolis.course.java2016.girevoy.home.testWorks.testHappensBefour.threads.BigChronoCheckThread;
import ru.innopolis.course.java2016.girevoy.home.testWorks.testHappensBefour.threads.ChronoThread;
import ru.innopolis.course.java2016.girevoy.home.testWorks.testHappensBefour.threads.ControllThread;

/**
 * Created by masterlomaster on 07.10.16.
 */
public class TestHappensBefour {
	public static void main(String[] args) {
		ChronoThread chronoThread = new ChronoThread(0);
		chronoThread.start();
		ControllThread controllThread = new ControllThread(chronoThread);

		BigChronoCheckThread thread1 = new BigChronoCheckThread(5);
		BigChronoCheckThread thread2 = new BigChronoCheckThread(3);

		controllThread.addNewBigChronoThread(thread1);
		controllThread.addNewBigChronoThread(thread2);

		controllThread.start();
	}
}
