package se.guards.weblayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import se.datalayer.guards.service.DateTimeUtils;

@Controller
@RequestMapping
public class LoginController
{
	@Autowired
	private static DateTimeUtils timeUtils= new DateTimeUtils();
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String login(ModelMap model)
	{

		return "index";

	}

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model)
	{

		model.addAttribute("error", "true");
		return "/index";

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model)
	{

		return "/index";

	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String printWelcome(ModelMap model, SecurityContextHolderAwareRequestWrapper request)
	{
		model.addAttribute("username", getCurrentUsername());
//		model.addAttribute("month", DateTimeUtils.getNameOfTheMonth());
//		model.addAttribute("monthNr", DateTimeUtils.getNumberOfTheMonth());
//		model.addAttribute("dayNr", DateTimeUtils.getDayNumber());
//		model.addAttribute("dayName", DateTimeUtils.getDayOfTheWeek().getAsShortText());
//		model.addAttribute("NameOfTheMonth", DateTimeUtils.getNameOfTheMonth());
//		model.addAttribute("year", DateTimeUtils.getOnlyYear());

		if (request.isUserInRole("ROLE_ADMIN"))
		{
			return "admin";
		}
		else if (request.isUserInRole("ROLE_USER"))
		{
			
			return "redirect:/availableCalendar";
		}

		else
		{
			return "/index";
		}
	}
	private String getCurrentUsername() {
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return obj instanceof UserDetails ? ((UserDetails) obj).getUsername() : obj.toString();
    }

}