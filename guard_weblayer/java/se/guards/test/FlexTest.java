package se.guards.test;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import se.datalayer.guards.service.UserService;
import se.guard.User;

@Controller
@RequestMapping 
public class FlexTest
{

	@Autowired(required=false)
	private static UserService us = new UserService();
	
	@RequestMapping(value="flexlayout", method=RequestMethod.GET)
	public String getFlexLayout(ModelMap model){
		
		model.addAttribute("currentUser", getCurrentUsername());
		Collection<User> list = us.findAllUsers();
		model.addAttribute("allUsers", list);
		return "flexlayout";
	}
	
	private String getCurrentUsername() {
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return obj instanceof UserDetails ? ((UserDetails) obj).getUsername() : obj.toString();
    } 
	

}
