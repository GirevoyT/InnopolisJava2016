package ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.logica;

import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;

import static org.junit.Assert.*;

/**
 * Created by Arxan on 14.10.2016.
 */
public class MyTaskIntegerLogicaTest {
	private static Logger logger = LoggerFactory.getLogger(MyTaskIntegerLogicaTest.class);

	@BeforeClass
	public static void beforeTest() {
		logger.info("This is @BeforeClass method");
	}
	@Before
	public void before() {
		logger.info("This is @Before method");
	}

	@Test
	public void testLogicaAndGetResult() {
		logger.info("This is @Test method testLogicaAndGetResult");
		Logica logica = new MyTaskIntegerLogica();
		logica.logica(10);
		logica.logica(100);
		logica.logica(-5);
		logica.logica(5);
		assertEquals("Logica неправильно отработала (разучились складывать)",logica.getResult(),BigInteger.valueOf(110));
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
