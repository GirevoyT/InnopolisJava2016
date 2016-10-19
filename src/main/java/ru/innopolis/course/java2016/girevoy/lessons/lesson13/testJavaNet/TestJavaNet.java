package ru.innopolis.course.java2016.girevoy.lessons.lesson13.testJavaNet;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by masterlomaster on 19.10.16.
 */
public class TestJavaNet {
	public static void main(String[] args) throws IOException {
		URL url = new URL("https://www.ya.ru");
		System.out.println();
		Scanner scanner = new Scanner(url.openStream());
		while (scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
		scanner.close();
	}
}
