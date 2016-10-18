package ru.innopolis.course.java2016.girevoy.lessons.lesson9.testjMock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.course.java2016.girevoy.lessons.lesson9.testjMock.streams.StreamWriter;
import ru.innopolis.course.java2016.girevoy.lessons.lesson9.testjMock.streams.WSStreamWriter;

/**
 * Created by masterlomaster on 13.10.16.
 */
public class TestjMock {
	private static Logger logger = LoggerFactory.getLogger(TestjMock.class);

	private StreamWriter streamWriter = new WSStreamWriter();

	public static void main(String[] args) {

	}

	public Long handle(String arg) {
		Long key = this.streamWriter.write(arg);
		logger.info("Methode handle arg = {}",arg);
		return key;
	}

	public StreamWriter getStreamWriter() {
		return streamWriter;
	}

	public void setStreamWriter(StreamWriter streamWriter) {
		this.streamWriter = streamWriter;
	}
}
