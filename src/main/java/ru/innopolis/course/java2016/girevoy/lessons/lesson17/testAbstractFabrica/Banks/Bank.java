package ru.innopolis.course.java2016.girevoy.lessons.lesson17.testAbstractFabrica.Banks;

import ru.innopolis.course.java2016.girevoy.lessons.lesson17.testAbstractFabrica.Contributions.Contribution;
import ru.innopolis.course.java2016.girevoy.lessons.lesson17.testAbstractFabrica.Credits.Credit;
import ru.innopolis.course.java2016.girevoy.lessons.lesson17.testAbstractFabrica.Insurences.Insurance;

/**
 * Created by Arxan on 25.10.2016.
 */
public class Bank {
	private Contribution contribution;
	private Credit credit;
	private Insurance insurance;

	public void setContribution(Contribution contribution) {
		this.contribution = contribution;
	}

	public void setCredit(Credit credit) {
		this.credit = credit;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	public Contribution getContribution() {
		return contribution;
	}

	public Credit getCredit() {
		return credit;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	Bank() {

	}
}
