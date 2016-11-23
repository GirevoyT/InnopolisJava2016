package ru.innopolis.adressbook.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.adressbook.common.models.contact.ContactService;

@Controller
@RequestMapping("/MainBookPage")
public class MainBookPage {
//	@Autowired
//	ContactService contactService;

	@RequestMapping("")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("MainBookPage/index");
		return modelAndView;
	}
}
