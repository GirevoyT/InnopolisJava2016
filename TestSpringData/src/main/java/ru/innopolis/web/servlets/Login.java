package ru.innopolis.web.servlets;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
		modelAndView.setViewName("loginZone");
		modelAndView.addObject("username", getUserName());
		return modelAndView;
	}

	@RequestMapping("/403")
	public ModelAndView accesssDenied() {
		ModelAndView modelAndView = new ModelAndView();
		//check if user is login
		modelAndView.addObject("username", getUserName());
		modelAndView.setViewName("403");
		return modelAndView;
	}

	private String getUserName() {
		String result="ANONIM";
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			result = userDetail.getUsername();
		}
		return result;
	}
}
