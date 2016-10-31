package ru.innopolis.web.servlets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.common.models.student.Student;
import ru.innopolis.common.models.student.StudentService;
import ru.innopolis.common.models.student.exeptions.StudentServiceDataExeption;

import java.util.List;

/**
 * Created by Girevoy.T on 31.10.2016.
 */
@Controller
public class Index {
	@Autowired
	StudentService studentService;

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping("")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}

	@RequestMapping("/index/studentTable")
	public ModelAndView doSome() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("studentTable");
		try {
			List<Student> qwe = studentService.getStudentsList();
			modelAndView.addObject("studentArray",qwe);
		} catch (StudentServiceDataExeption studentServiceDataExeption) {
			studentServiceDataExeption.printStackTrace();
		}
		return modelAndView;
	}
}
