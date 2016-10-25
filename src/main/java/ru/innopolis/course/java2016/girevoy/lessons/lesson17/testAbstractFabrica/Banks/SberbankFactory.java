package ru.innopolis.course.java2016.girevoy.lessons.lesson17.testAbstractFabrica.Banks;

import ru.innopolis.course.java2016.girevoy.lessons.lesson17.testAbstractFabrica.Contributions.Contribution;
import ru.innopolis.course.java2016.girevoy.lessons.lesson17.testAbstractFabrica.Contributions.Contribution100;
import ru.innopolis.course.java2016.girevoy.lessons.lesson17.testAbstractFabrica.Credits.Credit;
import ru.innopolis.course.java2016.girevoy.lessons.lesson17.testAbstractFabrica.Credits.Credit10x3;
import ru.innopolis.course.java2016.girevoy.lessons.lesson17.testAbstractFabrica.Insurences.Insurance;
import ru.innopolis.course.java2016.girevoy.lessons.lesson17.testAbstractFabrica.Insurences.InsuranceLife;

/**
 * Created by Arxan on 25.10.2016.
 */
public class SberbankFactory implements AbstractBankFactory {
	@Override
	public Contribution createContribution() {
		return new Contribution100();
	}

	@Override
	public Credit createCredit() {
		return new Credit10x3();
	}

	@Override
	public Insurance createInsurance() {
		return new InsuranceLife();
	}

}
