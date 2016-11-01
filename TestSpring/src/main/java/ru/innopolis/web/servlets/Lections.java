package ru.innopolis.web.servlets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.common.models.lection.Lection;
import ru.innopolis.common.models.lection.LectionService;
import ru.innopolis.common.models.lection.exeptions.LectionServiceDataExeption;

import java.util.List;

/**
 * Created by Girevoy.T on 01.11.2016.
 */
@Controller
@RequestMapping("/lections")
public class Lections {
	@Autowired
	LectionService lectionService;

	public void setLectionService(LectionService lectionService) {
		this.lectionService = lectionService;
	}

	@RequestMapping("/lectionsTable")
	public ModelAndView viewTable() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("lectionsTable");
		try {
			List<Lection> tmp = lectionService.getLectionsList();
			modelAndView.addObject("lectionArray",tmp);
		} catch (LectionServiceDataExeption e) {
			e.printStackTrace();
		}
		return modelAndView;
	}
}
