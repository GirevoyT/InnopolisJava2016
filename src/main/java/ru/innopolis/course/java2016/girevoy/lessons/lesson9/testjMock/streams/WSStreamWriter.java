package ru.innopolis.course.java2016.girevoy.lessons.lesson9.testjMock.streams;

/**
 * Created by masterlomaster on 13.10.16.
 */
public class WSStreamWriter implements StreamWriter {

	@Override
	public Long write(String obj) {
//		тут какаято сложная логика так что выбросим исключение
		throw new RuntimeException("Ещё не готов");
	}
}
