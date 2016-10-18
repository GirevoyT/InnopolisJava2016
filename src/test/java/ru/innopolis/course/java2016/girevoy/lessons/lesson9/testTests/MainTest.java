package ru.innopolis.course.java2016.girevoy.lessons.lesson9.testTests;

import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.Assert.*;

/**
 * Created by masterlomaster on 13.10.16.
 */
public class MainTest {
	private static Logger logger = LoggerFactory.getLogger(MainTest.class);
	private Main main;


	@BeforeClass
	public static void beforeTest() {
		logger.info("This is @BeforeClass method");
	}
	@Before
	public void before() {
		logger.info("This is @Before method");
		this.main = new Main();
	}
	@Test
	public void testIsHelloWorld() {
		logger.info("This is @Test method testIsHelloWorld");
		assertTrue("Arg is not HelloWorld!",this.main.isHelloWorld("HelloWorld"));
		assertFalse("True when arg is not HelloWorld!",this.main.isHelloWorld("akajshd"));
	}
	@Test
	public void testIsString() {
		logger.info("This is @Test method testIsString");
		assertTrue("Arg is not String!",this.main.isString("HAO!"));
		assertFalse("True when arg is not String!",this.main.isString(10));
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
