package ru.innopolis.course.java2016.girevoy.lessons.lesson17.testAbstractFabrica.Banks;

import ru.innopolis.course.java2016.girevoy.lessons.lesson17.testAbstractFabrica.Contributions.Contribution;
import ru.innopolis.course.java2016.girevoy.lessons.lesson17.testAbstractFabrica.Contributions.Contribution3Month;
import ru.innopolis.course.java2016.girevoy.lessons.lesson17.testAbstractFabrica.Credits.Credit;
import ru.innopolis.course.java2016.girevoy.lessons.lesson17.testAbstractFabrica.Credits.Credit0;
import ru.innopolis.course.java2016.girevoy.lessons.lesson17.testAbstractFabrica.Insurences.Insurance;
import ru.innopolis.course.java2016.girevoy.lessons.lesson17.testAbstractFabrica.Insurences.InsuranceHome;

/**
 * Created by Arxan on 25.10.2016.
 */
public class VTBFactory implements AbstractBankFactory {
	@Override
	public Contribution createContribution() {
		return new Contribution3Month();
	}

	@Override
	public Credit createCredit() {
		return new Credit0();
	}

	@Override
	public Insurance createInsurance() {
		return new InsuranceHome();
	}
}
