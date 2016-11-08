package ru.innopolis.course.java2016.girevoy.lessons.lesson27.otherChainElements;

import ru.innopolis.course.java2016.girevoy.lessons.lesson27.ChainEllement;

/**
 * Created by Girevoy.T on 08.11.2016.
 */
public class BannerEllement extends ChainEllement {
	@Override
	protected Object doWork(Object msg) {
		System.out.println("Реши все свои проблемы, купи слона!");
		return msg;
	}
}
