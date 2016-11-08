package ru.innopolis.course.java2016.girevoy.lessons.lesson27.otherChainElements;

import ru.innopolis.course.java2016.girevoy.lessons.lesson27.ChainEllement;
import ru.innopolis.course.java2016.girevoy.lessons.lesson27.ChainEllementExeption;

/**
 * Created by Arxan on 08.11.2016.
 */
public class SoutNumberEllement extends ChainEllement {
	@Override
	protected Object doWork(Object msg) throws ChainEllementExeption {
		if (msg instanceof Number) {
			System.out.println(msg);
		} else {
			throw new ChainEllementExeption("Для вывода получен не Number");
		}
		return msg;
	}
}
