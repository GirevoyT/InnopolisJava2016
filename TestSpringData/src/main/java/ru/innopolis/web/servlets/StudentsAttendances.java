package ru.innopolis.web.servlets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.common.models.studentAttendences.StudentAttendance;
import ru.innopolis.common.models.studentAttendences.StudentAttendanceService;
import ru.innopolis.common.models.studentAttendences.exeptions.StudentAttendanceDataExeption;

import java.util.List;

/**
 * Created by Girevoy.T on 01.11.2016.
 */
@Controller
@RequestMapping("/studentsAttendances")
public class StudentsAttendances {
	@Autowired
	private StudentAttendanceService studentAttendanceService;

	public void setStudentAttendanceService(StudentAttendanceService studentAttendanceService) {
		this.studentAttendanceService = studentAttendanceService;
	}

	@RequestMapping("/studentsAttendancesTable")
	public ModelAndView viewTable() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("studentsAttendances");
		try {
			List<StudentAttendance> tmp = studentAttendanceService.getSudentAttendanceList();
			modelAndView.addObject("studentsAttendancesArray",tmp);
		}catch (StudentAttendanceDataExeption studentAttendanceDataExeption) {
			studentAttendanceDataExeption.printStackTrace();
		}
		return modelAndView;
	}
}
