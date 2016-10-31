package ru.innopolis.common.models.student;

/**
 * Created by Girevoy.T on 31.10.2016.
 */
public enum Sex{
	Male,
	Female;

	@Override
	public String toString() {
		String result;
		if (this.equals(Male)) {
			result = "Male";
		} else {
			result = "Female";
		}
		return result;
	}
}