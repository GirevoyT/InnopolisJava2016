package ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.devourers;

import org.hamcrest.Description;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.States;
import org.jmock.api.Action;
import org.jmock.api.Invocation;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.action.ReturnValueAction;
import org.jmock.lib.concurrent.Synchroniser;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.DeepThought;
import ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.resource.Resource;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Created by masterlomaster on 14.10.16.
 */
public class DevourerTest {
	private static Logger logger = LoggerFactory.getLogger(DevourerTest.class);
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
			this.setImposteriser(ClassImposteriser.INSTANCE);
			this.setThreadingPolicy(synchroniser);
		}};;

	}
	@Test
	public void testDevourer() {
		logger.info("This is @Test method testDevourer");
		ThreadGroup threadGroup= new ThreadGroup("testGroup");
		Object testObject = new CheckBox();
		Resource resource = context.mock(Resource.class);
		DeepThought deepThought = context.mock(DeepThought.class);

		final States progress = context.states("progress").startsAs("none");

		context.checking(new Expectations(){{
			oneOf(resource).hasNext();
			will(new ReturnValueAction(true));
			when(progress.is("none")); then(progress.is("half"));

			oneOf(resource).hasNext();
			will(new ReturnValueAction(false));
			when(progress.is("half")); then(progress.is("half"));

			oneOf(resource).next();
			will(new ReturnValueAction(testObject));

			oneOf(resource).isComplite();
			will(new ReturnValueAction(true));

			oneOf(deepThought).addData(testObject);
			will(new CheckLogicaAction(testObject));
			then(progress.is("done"));
		}});

		Devourer devourer = new Devourer(resource,deepThought,threadGroup);
		try {
			devourer.start();
			synchroniser.waitUntil(progress.is("done"), TimeUnit.SECONDS.toMillis(1));
			threadGroup.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertTrue("Devourer не выполнил передачу, или передал не тот объект",((CheckBox)testObject).isFlag());
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

