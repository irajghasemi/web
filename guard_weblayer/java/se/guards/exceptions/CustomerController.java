package se.guards.exceptions;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

@Controller
public class CustomerController {

	@ExceptionHandler(NoSuchRequestHandlingMethodException.class)
	public ModelAndView handleNoSuchRequestException(NoSuchRequestHandlingMethodException ex) {
	    ModelMap model = new ModelMap();
	        model.addAttribute("modelkey", "modelvalue");
	        return new ModelAndView("/serverError", model);
	}

	@ExceptionHandler(NullPointerException.class)
	public ModelAndView handleAllExceptions(NullPointerException e) {
	        ModelMap model = new ModelMap();
	        model.addAttribute("modelkey", "modelvalue");
	        return new ModelAndView("/serverError", model);
	}

}     