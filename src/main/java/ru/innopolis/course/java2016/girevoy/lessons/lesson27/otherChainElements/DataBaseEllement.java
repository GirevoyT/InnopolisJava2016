package ru.innopolis.course.java2016.girevoy.lessons.lesson27.otherChainElements;

import lombok.extern.slf4j.Slf4j;
import ru.innopolis.course.java2016.girevoy.lessons.lesson27.ChainEllement;

/**
 * Created by Girevoy.T on 08.11.2016.
 */
@Slf4j
public class DataBaseEllement extends ChainEllement {
	@Override
	protected Object doWork(Object msg) {
		log.info("Типо записали в БД");
		return msg;
	}
}
