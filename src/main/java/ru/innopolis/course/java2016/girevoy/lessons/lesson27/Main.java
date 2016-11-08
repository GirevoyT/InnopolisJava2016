package ru.innopolis.course.java2016.girevoy.lessons.lesson27;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * Created by Girevoy.T on 08.11.2016.
 */
@Slf4j
public class Main {
	public static void main(String[] args) {
		log.info("Success");
		ActionChain actionChain = ActionChain.getInstance();
		Scanner scanner = new Scanner(System.in);
		inf:
		while (true) {
			System.out.println("Ready for input");;
			String command = scanner.nextLine();
			try {
				actionChain.start(command);
			} catch (TimeToBreakExeption timeToBreakExeption) {
				break inf;
			}
		}
	}
}
