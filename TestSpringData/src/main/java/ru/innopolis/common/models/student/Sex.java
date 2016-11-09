package ru.innopolis.common.models.student;

/**
 * Enum для хранения поля
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