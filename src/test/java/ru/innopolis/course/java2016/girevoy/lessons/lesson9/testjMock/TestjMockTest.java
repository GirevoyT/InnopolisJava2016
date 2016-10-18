package ru.innopolis.course.java2016.girevoy.lessons.lesson9.testjMock;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.course.java2016.girevoy.lessons.lesson9.testjMock.streams.StreamWriter;

import static org.junit.Assert.assertEquals;

/**
 * Created by masterlomaster on 13.10.16.
 */
public class TestjMockTest {
	private static Logger logger = LoggerFactory.getLogger(TestjMockTest.class);
	private TestjMock testjMock;
	private Mockery context;


	@BeforeClass
	public static void beforeTest() {
		logger.info("This is @BeforeClass method");
	}
	@Before
	public void before() {
		logger.info("This is @Before method");
		this.testjMock = new TestjMock();
		this.context = new JUnit4Mockery();
	}
	@Test
	public void testHandle() {
		logger.info("This is @Test method testSum");
		final StreamWriter streamWriter = context.mock(StreamWriter.class);

		context.checking(new Expectations() {{
			oneOf(streamWriter).write("SomeText");
			will(returnValue(new Long(5)));
		}});
		testjMock.setStreamWriter(streamWriter);
		assertEquals(new Long(5),testjMock.handle("SomeText"));
	}
	@After
	public void after() {
		logger.info("This is @Arter method");
	}
	@AfterClass
	public static void afterClass() {
		logger.info("This is @ArterClass method");
	}

}
