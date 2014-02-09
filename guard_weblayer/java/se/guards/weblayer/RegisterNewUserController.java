package se.guards.weblayer;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import se.datalayer.guards.service.UserService;
import se.guard.Address;
import se.guard.Role;
import se.guard.User;

@Controller
@SessionAttributes("user")
@RequestMapping
public class RegisterNewUserController
{

	private static UserService us = new UserService();
	

	@RequestMapping(value = "/addnewuser", method = RequestMethod.GET)
	public String showNewUserRegisterationsForm(ModelMap model, HttpServletRequest req, User user)
	{
		model.addAttribute("currentUser", getCurrentUsername());
		Address address = new Address();
		model.addAttribute("user", user);
		model.addAttribute("address", address);
		return "addnewuser";
	}

	@RequestMapping(value = "/added", method = RequestMethod.GET)
	public String showPageWhenNewUserAdded()
	{
		return "redirect:/getAllUsers";
	}

	@RequestMapping(value = "/addnewuser", method = RequestMethod.POST)
	public String addNewUser(@ModelAttribute("user") User user, ModelMap model)
	{
		model.addAttribute("currentUser", getCurrentUsername());
		List<Role> roles_user = new ArrayList<Role>();
		String role_user = "ROLE_USER";
		roles_user.add(new Role(role_user));
		boolean enabled = true;
		
		Address address = new Address(user.getAddress().getStreet(), user.getAddress().getZipcode(), user.getAddress().getCity());
		User newUser = new User(user.getFirstname(), user.getLastname(), user.getCivicregnumber(),user.getUsername(),user.getPassword(), user.getEmail(), enabled, address, roles_user);
		us.addNewUser(newUser);

		return "redirect:/getAllUsers";
	}    
	
	

	@RequestMapping(value = "/addnewadmin")
	public String showAddNewAdmin(ModelMap model)
	{
		model.addAttribute("currentUser", getCurrentUsername());
		return "addnewadmin";
	}

	@RequestMapping(value = "/addnewadmin", method = RequestMethod.POST)
	public String addNewAdmin(@ModelAttribute("admin") User user, ModelMap model)
	{
		model.addAttribute("currentUser", getCurrentUsername());
		List<Role> roles_user = new ArrayList<Role>();
		String role_admin = "ROLE_ADMIN";
		boolean enabled = true;
		roles_user.add(new Role(role_admin));

		Address address = new Address(user.getAddress().getStreet(), user.getAddress().getZipcode(), user.getAddress().getCity());
		User newUser = new User(user.getFirstname(), user.getLastname(),user.getCivicregnumber(), user.getUsername(), user.getPassword(), user.getEmail(), enabled, address, roles_user);
		 model.addAttribute("admin", user);
		us.updateUser(newUser);

		return "redirect:/adminadded";
	}

	@RequestMapping(value = "/adminadded")
	public String adminAded()
	{
		return "redirect:/getAllUsers";
	}  
	private String getCurrentUsername() {
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return obj instanceof UserDetails ? ((UserDetails) obj).getUsername() : obj.toString();
    } 
	
	
}
