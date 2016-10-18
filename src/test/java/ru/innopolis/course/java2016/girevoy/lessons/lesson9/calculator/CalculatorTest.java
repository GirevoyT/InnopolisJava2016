package ru.innopolis.course.java2016.girevoy.lessons.lesson9.calculator;

import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.course.java2016.girevoy.lessons.lesson9.testTests.MainTest;
import static org.junit.Assert.*;

/**
 * Created by masterlomaster on 13.10.16.
 */
public class CalculatorTest {
	private static Logger logger = LoggerFactory.getLogger(MainTest.class);
	private Calculator calculator;


	@BeforeClass
	public static void beforeTest() {
		logger.info("This is @BeforeClass method");
	}
	@Before
	public void before() {
		logger.info("This is @Before method");
		this.calculator = new Calculator();
	}
	@Test
	public void testSum() {
		logger.info("This is @Test method testSum");
		assertEquals("Вернулось неправильное значение сумы",calculator.sum(999,1000),(double)999 + (double)1000,0.00001);
		assertEquals("Вернулось неправильное значение сумы",calculator.sum(2000,5),(double)2000 + (double)5,0.00001);
	}
	@Test
	public void testMinus() {
		logger.info("This is @Test method testMinus");
		assertEquals("Вернулось неправильное значение разности",calculator.minus(999,1000),(double)999 - (double)1000,0.00001);
		assertEquals("Вернулось неправильное значение разности",calculator.minus(2000,5),(double)2000 - (double)5,0.00001);
	}
	@Test
	public void testMultiply() {
		logger.info("This is @Test method testMultiply");
		assertEquals("Вернулось неправильное значение умножения",calculator.multiply(999,1000),(double)999 * (double)1000,0.00001);
		assertEquals("Вернулось неправильное значение умножения",calculator.multiply(2000,5),(double)2000 * (double)5,0.00001);
	}
	@Test
	public void testDevision() {
		logger.info("This is @Test method testDevision");
		assertEquals("Вернулось неправильное значение деления",calculator.devision (999,1000),(double)999 / (double)1000,0.00001);
		assertEquals("Вернулось неправильное значение деления",calculator.devision(2000,5),(double)2000 / (double)5,0.00001);
	}
	@Test
	public void testSqrt() {
		logger.info("This is @Test method testSqrt");
		assertEquals("Вернулось неправильное значение корня",calculator.sqrt (999), Math.sqrt(999),0.00001);
		assertEquals("Вернулось неправильное значение корня",calculator.sqrt(2000),Math.sqrt(2000),0.00001);
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
