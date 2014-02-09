package se.guards.calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import se.datalayer.guards.service.DateTimeUtils;
import se.datalayer.guards.service.UserService;

@Controller
@RequestMapping(value = "/getdateandtime")
public class BokingTimeController
{

	@Autowired
	public static DateTimeUtils datetimeUtils;
	@Autowired
	public static UserService us;


	@RequestMapping( method = RequestMethod.GET)
	public String showTimeAndDate(@RequestParam("username") String username, Model model, HttpServletRequest request, HttpServletResponse response)
	{

		model.addAttribute("currentUser", getCurrentUsername());


		

		return "/bokingTime";
	}
	
	private String getCurrentUsername() {
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return obj instanceof UserDetails ? ((UserDetails) obj).getUsername() : obj.toString();
    } 

}
