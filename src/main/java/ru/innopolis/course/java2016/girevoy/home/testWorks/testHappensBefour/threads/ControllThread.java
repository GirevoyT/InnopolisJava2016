package ru.innopolis.course.java2016.girevoy.home.testWorks.testHappensBefour.threads;

import ru.innopolis.course.java2016.girevoy.home.testWorks.testHappensBefour.exeptions.BaidaExeption;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Arxan on 07.10.2016.
 */
public class ControllThread extends Thread{
	private ChronoThread chronoThread;
	private int prevTime;
	private Set<BigChronoCheckThread> setOfBigChrono = new HashSet<>();

	public ControllThread(ChronoThread chronoThread) {
		this.chronoThread = chronoThread;
	}

	public void addNewBigChronoThread (BigChronoCheckThread thread) {
		setOfBigChrono.add(thread);
		thread.start();
	}

	public void run() {
		while (!isInterrupted()) {
			try {
				synchronized (chronoThread) {
					do {
						chronoThread.wait();
					} while (prevTime == chronoThread.getTime());	//WARNING! Узнать про затратность 2 уровня блокировки
					if (chronoThread.getTime() - prevTime > 1) {
						throw (new BaidaExeption("Прошло больше 1 тика"));
					}
					prevTime = chronoThread.getTime();
				}
				synchronized (setOfBigChrono) {
					for (BigChronoCheckThread thread : setOfBigChrono) {
						if (prevTime % thread.getQuant() == 0) {
							synchronized (thread) {					//WARNING! Узнать есть ли какой iswait (пока думаю надо бы использховать лок)
								if (thread.isMarker()) {
									throw (new BaidaExeption("Попытка повторно запустить поток с квантом " + thread.getQuant() + ", когда даже не заупстился предыдущий"));
								}
								thread.notify();
								thread.setMarker(true);
							}
						}
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BaidaExeption e) {
				e.printStackTrace();
				this.interrupt();
			}
		}
	}
}
