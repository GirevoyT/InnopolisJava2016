//package ru.innopolis.course.java2016.girevoy.lessons.lesson17.testBuilder;
//
///**
// * Created by oem on 25.10.16.
// */
//public class ComputerBuildManager {
//	private AbstractComputerBuilder builder;
//	public ComputerBuildManager(AbstractComputerBuilder builder) {
//		this.builder = builder;
//	}
//
//	public Computer build() {
//		Computer result = null;
//		this.builder.createNewComputer().setMotherBoard().setProcessor().setMemory().setOS();
//		result = this.builder.getComputer();
//		return result;
//	}
//}
