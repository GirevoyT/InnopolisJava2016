package ru.innopolis.web.servlets;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Girevoy.T on 02.11.2016.
 */
@Controller
public class Login {

	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	@RequestMapping("/allok")
	public ModelAndView allOK() {
		return new Index().index();
	}
}
