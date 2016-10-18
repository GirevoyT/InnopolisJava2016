package ru.innopolis.course.java2016.girevoy.lessons.lesson3.testResource;

import ru.innopolis.course.java2016.girevoy.lessons.lesson3.testResource.Resource.DBResource;
import ru.innopolis.course.java2016.girevoy.lessons.lesson3.testResource.Resource.NetResource;

/**
 * Created by masterlomaster on 05.10.16.
 */
public class Main {
	public static void main(String[] args) {
		try (
				DBResource dbResource = new DBResource();
			 	NetResource netResource = new NetResource())
		{
			System.out.println("success");
			throw new Exception();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
