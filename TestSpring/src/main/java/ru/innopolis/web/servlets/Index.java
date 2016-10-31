package ru.innopolis.web.servlets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.common.models.student.Sex;
import ru.innopolis.common.models.student.Student;
import ru.innopolis.common.models.student.StudentService;
import ru.innopolis.common.models.student.exeptions.CreateStudentExeption;
import ru.innopolis.common.models.student.exeptions.StudentServiceDataExeption;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	public ModelAndView viewTable() {
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
	@RequestMapping("/index/deleteRow")
	public ModelAndView deleteStudent(@RequestParam("studentId") int studentId) {
		try {
			studentService.deleteStudentFromBaseById(studentId);
		} catch (StudentServiceDataExeption studentServiceDataExeption) {
			studentServiceDataExeption.printStackTrace();
		}
		return viewTable();
	}

	@RequestMapping("/index/addStudent")
	public ModelAndView addStudent(@RequestParam("studentFirstname") String studentFirstname,
								   @RequestParam("studentLastname") String studentLastname,
								   @RequestParam("studentSex") int studentSex,
								   @RequestParam("studentBirthDate") String studentBirthDate) {
		try {
			Student student = studentService.createNewStudent(studentFirstname,studentLastname,studentSex == 1 ? Sex.Male : Sex.Female,new SimpleDateFormat("yyyy-MM-dd").parse(studentBirthDate));
			studentService.addStudentToBase(student);
		} catch (CreateStudentExeption createStudentExeption) {
			createStudentExeption.printStackTrace();
		} catch (StudentServiceDataExeption studentServiceDataExeption) {
			studentServiceDataExeption.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return viewTable();
	}
}
