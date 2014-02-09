package se.guards.weblayer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import se.datalayer.guards.service.DisplayImageService;
import se.datalayer.guards.service.UserService;
import org.apache.log4j.Logger; 

import javax.annotation.Resource;

import org.springframework.security.core.session.SessionRegistryImpl; 

import se.guard.Address;
import se.guard.Role;
import se.guard.User;

@SuppressWarnings({ "restriction", "unused" })
@Controller
@RequestMapping 
public class UserController
{

	@Autowired(required=false)
	private static UserService us = new UserService();
	@Autowired
	private static DisplayImageService imgService = new DisplayImageService();
	
	@Resource(name="sessionRegistry")
	private SessionRegistryImpl sessionRegistry;
	
	protected static Logger logger = Logger.getLogger("controller");

	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public String showAllUsers(ModelMap model)
	{
		model.addAttribute("currentUser", getCurrentUsername());
		Collection<User> list = us.findAllUsers();
		model.addAttribute("allUsers", list);
		return "getAllUsers";
	}
	

	@RequestMapping(value = "/getuser", method = RequestMethod.GET)
	public String getSingelUserForUpdate(HttpServletRequest request, Model model)
	{
		model.addAttribute("currentUser", getCurrentUsername());
		
		String userId = request.getParameter("userid");
		int id=Integer.parseInt(userId);

		User user = us.findUserById(id);
		Address address = new Address(user.getAddress().getStreet(), user.getAddress().getZipcode(), user.getAddress().getCity());
		model.addAttribute("address", address);
		model.addAttribute("getuserforupdate", user);

		return "updateuser";
	}

	@RequestMapping(value = "/updateuser", method = RequestMethod.POST)
	public String updateUser(ModelMap model, HttpServletRequest request)
	{
		model.addAttribute("currentUser", getCurrentUsername());
		String userid = request.getParameter("userid");
		int id=Integer.parseInt(userid);
		String firstname= request.getParameter("firstname");
		String lastname= request.getParameter("lastname");
		String civicnumber= request.getParameter("civicregnumber");
		String password = request.getParameter("password");
		String username = request.getParameter("username");
		boolean isEnabled=true;
		String email= request.getParameter("email");
		String street = request.getParameter("street");
		String zipcode = request.getParameter("zipcode");
		String city = request.getParameter("city");
		Address address = new Address(street, zipcode, city);
		List<Role> roles_user = new ArrayList<Role>();
		String role_user = "ROLE_USER";
		roles_user.add(new Role(role_user));
		User user= new User(id,firstname, lastname,civicnumber, username, password, email, isEnabled, address,roles_user);
		us.updateUser(user);

		return "redirect:/getAllUsers"; 
	}

	@RequestMapping(value = "/deleteuser", method = RequestMethod.GET)
	public String deleteUser(HttpServletRequest request, Model model)
	{
		model.addAttribute("currentUser", getCurrentUsername());
		String id = request.getParameter("userid");
		int userid=Integer.parseInt(id);
		User user = us.findUserById(userid);
		us.deleteUser(user);
		return "redirect:/getAllUsers";
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsersPage(Model model) {
		model.addAttribute("currentUser", getCurrentUsername());
    	logger.debug("Received request to show users page");
    
    	logger.debug("Total logged-in users: " + sessionRegistry.getAllPrincipals().size());
    	logger.debug("List of logged-in users: ");
    	for (Object username: sessionRegistry.getAllPrincipals()) {
    		logger.debug(username);
    	}
//    	logger.debug("Total sessions including expired ones: " + sessionRegistry.getAllSessions(sessionRegistry.getAllPrincipals().get(0), true).size());
//    	logger.debug("Total sessions: " + sessionRegistry.getAllSessions(sessionRegistry.getAllPrincipals().get(0), false).size());

    	// Attach to model list of users and granted authorities
    	model.addAttribute("users", sessionRegistry.getAllPrincipals());
    	model.addAttribute("total", sessionRegistry.getAllPrincipals().size());
    	
    	// This will resolve to /WEB-INF/jsp/userspage.jsp
    	return "userspage";
	} 
	
	@RequestMapping(value = "/accessDenied",method=RequestMethod.GET)
    public String accessDenied() {

          return "403";
     }
	@RequestMapping(value = "/pageNotFound",method=RequestMethod.GET)
	public String AdminPageNotFound() {
		
		return "404";
	}
	@RequestMapping(value = "/unAuthorized",method=RequestMethod.GET)
	public String unAuthorized() {
		
		return "402";
	}
	@RequestMapping(value = "/serverError",method=RequestMethod.GET)
	public String serverError() {
		
		return "500";
	}
	
	@RequestMapping(value ="/badRequest",method=RequestMethod.GET)
	public String AdminBadRequest(Model model)
	{
		return "400";
	}
	
	private String getCurrentUsername() {
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return obj instanceof UserDetails ? ((UserDetails) obj).getUsername() : obj.toString();
    } 
	

}
