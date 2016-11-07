package ru.innopolis.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * Created by Arxan on 07.11.2016.
 */
public class MapperFactoryInstance {
	private static final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

	static {
		ConverterFactory converterFactory = mapperFactory.getConverterFactory();
		converterFactory.registerConverter(new SexToBooleanConverter());
	}
	private MapperFactoryInstance () {};

	public static MapperFactory getMapperFactoryInstance() {
		return mapperFactory;
	}
}
