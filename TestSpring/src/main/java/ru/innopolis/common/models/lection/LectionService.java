package ru.innopolis.common.models.lection;

import ru.innopolis.common.models.lection.exeptions.LectionServiceDataExeption;

import java.util.List;

/**
 * Created by Girevoy.T on 01.11.2016.
 */
public interface LectionService {
	public List<Lection> getLectionsList() throws LectionServiceDataExeption;
}
