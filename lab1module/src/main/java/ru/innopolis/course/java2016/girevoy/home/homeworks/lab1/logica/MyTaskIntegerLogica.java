package ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.logica;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by Arxan on 10.10.2016.
 */
public class MyTaskIntegerLogica implements Logica<Integer,BigInteger> {
	private BigInteger sum = BigInteger.valueOf(0);
	int mark = new Random().nextInt();
	Logger logger = LoggerFactory.getLogger(MyTaskIntegerLogica.class);

	/**
	 * Метож складывает все входящие в него числа и выводит промежуточные суммы в лог
	 * принимает Integer
	 * @param arg
	 */
	@Override
	public synchronized void logica(Integer arg) {
		if (arg!= null && (arg.intValue() > 0) && ((arg.intValue() % 2) == 0)) {
			sum = sum.add(BigInteger.valueOf(arg.intValue()));
			System.out.println("Текущее значение марка " + mark + " равно " + sum);
			logger.debug("Отработала логика, текущее значение марка {} равно {}",mark,sum);
		} else {
			logger.warn("Логике инт передали не положительное и чётное число, сумма не изменилась");
		}
	}

	/**
	 * Метод возвращаюший промежуточную сумму
	 * @return
	 */
	@Override
	public BigInteger getResult() {
		return sum;
	}
}
