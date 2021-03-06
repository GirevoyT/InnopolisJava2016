package ru.innopolis.web.servlets;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminPage {
	@RequestMapping("/admin_page")
	@Secured({"ROLE_ADMIN"})
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin_page");
		return modelAndView;
	}
}
