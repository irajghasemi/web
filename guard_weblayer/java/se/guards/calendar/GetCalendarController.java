package se.guards.calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import se.datalayer.guards.service.UserService;
import se.guard.User;

@Controller
public class GetCalendarController
{
	@Autowired
	private static UserService us= new UserService();

	@RequestMapping(value = "/calendar", method = RequestMethod.GET)
	public String showCalendar(ModelMap model, SecurityContextHolderAwareRequestWrapper request)
	{
		String user = request.getUserPrincipal().getName();
		model.addAttribute("loggedUserById", getCurrentUsername());
		User user1 = us.findUserByAnyParameter(user);
		System.out.println(user1);
		model.addAttribute("user", user1);
		return "calendar";
	}

	@RequestMapping(value = "/chosenDate", method = RequestMethod.GET)
	public String getDate(@RequestParam("date") String date, ModelMap model, SecurityContextHolderAwareRequestWrapper request)
	{

		System.out.println("The chosen date is: " + date);
//		String user = request.getUserPrincipal().getName();
		model.addAttribute("loggedUserById", getCurrentUsername());
//		User user1 = us.findUserByAnyParameter(user);
		model.addAttribute("getDtae", date);

		return "chosenDate";
	}
	
	private String getCurrentUsername() {
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return obj instanceof UserDetails ? ((UserDetails) obj).getUsername() : obj.toString();
    } 

}
