package se.guards.image;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UploadFileIndexController {

	// Display the form on the get request
	@RequestMapping(value="/uploadfileindex",method = RequestMethod.GET)
	public String showRegistration(ModelMap model) {
		return "uploadfileindex";
	}

	// Process the form.
	@RequestMapping(value="/uploadfileindex",method = RequestMethod.POST)
	public String processRegistration(BindingResult result) {
		return "uploadfileindex";
	}
}
