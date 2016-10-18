package ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.resource;

import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Arxan on 14.10.2016.
 */
public class ResourceCheckerTest {
	private static Logger logger = LoggerFactory.getLogger(ResourceCheckerTest.class);

	@BeforeClass
	public static void beforeTest() {
		logger.info("This is @BeforeClass method");
	}
	@Before
	public void before() {
		logger.info("This is @Before method");
	}

	@Test
	public void testIsFile() {
		logger.info("This is @Test method testIsFile");
		assertTrue("Метод не определил файл",ResourceChecker.isFile("./build.gradle"));
		assertFalse("Метод определил как файл некоректную строку",ResourceChecker.isFile("lakjshdkjhasd"));
	}

	@Test
	public void testIsURL() {
		logger.info("This is @Test method testIsURL");
		assertTrue("Метод не определил ссылку",ResourceChecker.isURL("https://habrahabr.ru/post/136466/"));
		assertFalse("Метод определил как ссылку некоректную строку",ResourceChecker.isFile("флыораывалор"));
	}

	@Test
	public void testCreateResourceBySting() {
		logger.info("This is @Test method testCreateResourceBySting");
		ThreadGroup threadGroup = new ThreadGroup("TEST");
		assertTrue("Метод вернул некоректный ресурс",ResourceChecker.createResourceBySting("https://habrahabr.ru/post/136466/",threadGroup) instanceof SafetyURLResource);
		assertFalse("Метод вернул объект на невозможный ресурс",ResourceChecker.createResourceBySting("asdasd",threadGroup) instanceof SafetyURLResource);
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
