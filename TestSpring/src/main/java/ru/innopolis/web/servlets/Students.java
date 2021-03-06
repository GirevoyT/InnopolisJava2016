package ru.innopolis.web.servlets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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
 * Created by Girevoy.T on 01.11.2016.
 */
@Controller
@RequestMapping("/students")
@Secured("ROLE_TEATCHER")
public class Students {
	@Autowired
	private StudentService studentService;
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}


	@RequestMapping("/studentTable")
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
	@RequestMapping("/deleteRow")
	public ModelAndView deleteStudent(@RequestParam("studentId") int studentId) {
		try {
			studentService.deleteStudentFromBaseById(studentId);
		} catch (StudentServiceDataExeption studentServiceDataExeption) {
			studentServiceDataExeption.printStackTrace();
		}
		return viewTable();
	}

	@RequestMapping("/addStudent")
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
