package ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.homeworks.lab1.logica;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by Arxan on 10.10.2016.
 */
public class MyTaskIntegerLogica implements Logica<Integer> {
	private BigInteger sum = BigInteger.valueOf(0);
	int mark = new Random().nextInt();
	@Override
	public synchronized void logica(Integer arg) {
		if ((arg.intValue() > 0) && ((arg.intValue() % 2) == 0)) {
			sum = sum.add(BigInteger.valueOf(arg.intValue()));
			System.out.println("Текущее значение марка " + mark + " равно " + sum);
		}
	}
}
