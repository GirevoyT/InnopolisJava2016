package ru.innopolis.course.java2016.girevoy.home.homeworks.lab1;

import org.hamcrest.Description;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.States;
import org.jmock.api.Action;
import org.jmock.api.Invocation;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.logica.Logica;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Created by Arxan on 13.10.2016.
 */
public class DeepThoughtTest {
	private static Logger logger = LoggerFactory.getLogger(DeepThoughtTest.class);
	private Synchroniser synchroniser = new Synchroniser();
	private Mockery context;

	@BeforeClass
	public static void beforeTest() {
		logger.info("This is @BeforeClass method");
	}
	@Before
	public void before() {
		logger.info("This is @Before method");
		this.context = new JUnit4Mockery() {{
			this.setThreadingPolicy(synchroniser);
		}};;

	}
	@Test
	public void testDeepThought() {
		logger.info("This is @Test method testDeepThought");
		ThreadGroup threadGroup= new ThreadGroup("testGroup");
		Object testObject = new CheckBox();
		Logica logica = context.mock(Logica.class);

		final States progress = context.states("progress").startsAs("none");
		context.checking(new Expectations(){{
			oneOf(logica).logica(testObject);
			will(new CheckLogicaAction(testObject));
			then(progress.is("done"));
		}});
		DeepThought deepThought = new DeepThought(logica, threadGroup);
		try {
			deepThought.addData(testObject);
			deepThought.start();
			synchroniser.waitUntil(progress.is("done"), TimeUnit.SECONDS.toMillis(1));
			threadGroup.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertTrue("Deepthroug не выполнил логику, или передал не тот объект",((CheckBox)testObject).isFlag());
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

class CheckBox {
	private boolean flag;

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
class CheckLogicaAction implements Action {
	private Object result;
	private Logger logger = LoggerFactory.getLogger(CheckLogicaAction.class);

	public CheckLogicaAction(Object result) {
		this.result = result;
	}

	public Object invoke(Invocation invocation) throws Throwable {
		((CheckBox)result).setFlag(true);
		logger.info("Была вызвана логика с объектом {}", this.result.toString());
		return null;
	}

	public void describeTo(Description description) {
		description.appendText("returns ");
		description.appendValue(result);
	}
}
