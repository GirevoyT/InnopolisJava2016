package ru.innopolis.common.models.studentXLection;

import ru.innopolis.common.models.studentXLection.exeptions.StudentXLectionDataExeption;

import java.util.List;

/**
 * Created by Girevoy.T on 01.11.2016.
 */
public interface StudentXLectionService {

	public List<StudentXLection> getSudentXLectionList() throws StudentXLectionDataExeption;
}
