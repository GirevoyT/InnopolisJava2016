package ru.innopolis.course.java2016.girevoy.lessons.lesson17.testAbstractFabrica.Banks;

import ru.innopolis.course.java2016.girevoy.lessons.lesson17.testAbstractFabrica.Contributions.Contribution;
import ru.innopolis.course.java2016.girevoy.lessons.lesson17.testAbstractFabrica.Credits.Credit;
import ru.innopolis.course.java2016.girevoy.lessons.lesson17.testAbstractFabrica.Insurences.Insurance;

/**
 * Created by Arxan on 25.10.2016.
 */
public interface AbstractBankFactory {
	public Contribution createContribution();
	public Credit createCredit();
	public Insurance createInsurance();

	public default Bank build(){
		Bank result;
		result = new Bank();
		result.setContribution(createContribution());
		result.setCredit(createCredit());
		result.setInsurance(createInsurance());
		return result;
	};
}
