package controllers;

import calc.Calc;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Girevoy.T on 31.10.2016.
 */
@Controller
public class Index {
	@Autowired
	@Getter
	@Setter
	private Calc calc;

	@RequestMapping("/index")
	public ModelAndView index() {
		String tmp = calc.hello("asd");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}
}
