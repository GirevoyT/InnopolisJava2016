package ru.innopolis.mapper;

import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;
import ru.innopolis.common.models.student.Sex;

/**
 * Created by Arxan on 07.11.2016.
 */
public class SexToBooleanConverter extends BidirectionalConverter<Sex,Boolean> {

	@Override
	public Boolean convertTo(Sex source, Type<Boolean> destinationType) {
		boolean result = false;
		if (Sex.Female.equals(source)) {
			result = false;
		} else if (Sex.Male.equals(source)) {
			result = true;
		}
		return result;
	}

	@Override
	public Sex convertFrom(Boolean source, Type<Sex> destinationType) {
		Sex result;
		if (!source) {
			result = Sex.Female;
		} else {
			result = Sex.Male;
		}
		return result;
	}
}