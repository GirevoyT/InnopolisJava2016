package ru.innopolis.course.java2016.girevoy.lessons.lesson17.testAbstractFabrica.Banks;

import ru.innopolis.course.java2016.girevoy.lessons.lesson17.testAbstractFabrica.Contributions.Contribution;
import ru.innopolis.course.java2016.girevoy.lessons.lesson17.testAbstractFabrica.Credits.Credit;
import ru.innopolis.course.java2016.girevoy.lessons.lesson17.testAbstractFabrica.Insurences.Insurance;

/**
 * Created by Arxan on 25.10.2016.
 */
public class FabricaAbstracrFabrici {

	public AbstractBankFactory getAbstractFabrica(String name) {
		AbstractBankFactory result = null;
		switch (name) {
			case "VTB":
				result = new VTBFactory();
				break;
			case "SberBank":
				result = new SberbankFactory();
				break;
		}
		return result;
	}
}
