package ru.innopolis.web.servlets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.common.models.studentXLection.StudentXLection;
import ru.innopolis.common.models.studentXLection.StudentXLectionService;
import ru.innopolis.common.models.studentXLection.exeptions.StudentXLectionDataExeption;

import java.util.List;

/**
 * Created by Girevoy.T on 01.11.2016.
 */
@Controller
@RequestMapping("/studentsXLection")
public class StudentXLectionServlet {
	@Autowired
	private StudentXLectionService studentXLectionService;
	public void setStudentXLectionService(StudentXLectionService studentXLectionService) {
		this.studentXLectionService = studentXLectionService;
	}
	@RequestMapping("/studentsXLectionTable")
	public ModelAndView viewTable() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("studentsXLection");
		try {
			List<StudentXLection> tmp = studentXLectionService.getSudentXLectionList();
			modelAndView.addObject("studentsXLectionArray",tmp);
		}catch (StudentXLectionDataExeption studentXLectionDataExeption) {
			studentXLectionDataExeption.printStackTrace();
		}
		return modelAndView;
	}
}
