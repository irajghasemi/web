package se.guards.resetpassword;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import se.datalayer.guards.service.UserService;
import se.guard.Address;
import se.guard.Role;
import se.guard.User;

@Controller
public class ResetPasswordController
{

	private static final Logger logger = LoggerFactory.getLogger(ResetPasswordController.class);

	@Autowired(required=false)
	 public UserService service= new UserService();

//	@Autowired(required=false)
//	public ResetPasswordController(UserService service)
//	{
//		this.service = service;
//	}

	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		binder.setAllowedFields(new String[] { "confirm", "password", "username" });
	}

	@ModelAttribute("form")
	public ResetPasswordForm populateForm(@RequestParam("username") String username)
	{
		return new ResetPasswordForm(username);
	}

	@RequestMapping(value = "/password/reset", method = RequestMethod.GET)
	public String resetPassword(HttpServletRequest request, @RequestParam("frob") String frob)
	{
		logger.debug("Rendering reset password form.");
		Cookie cookie = null;
		for (Cookie c : request.getCookies())
		{
			if (c.getName().equals("frob"))
			{
				cookie = c;
			}
		}
		return isValidCookie(cookie, frob) ? "reset-password" : "reset-expired";
	}

	@RequestMapping(value = "/password/reset", method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute("form") ResetPasswordForm form,HttpServletRequest request, BindingResult result,HttpServletResponse response)
	{
		logger.debug("Processing reset password form.");
		SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
		User user=service.findUserByUsername(form.getUsername());
		new ResetPasswordFormValidator().validate(form, result);
		if (!result.hasErrors())
		{
			int id=user.getUserid();
    		String firstname= user.getFirstname();
    		String lastname= user.getLastname();
    		String password = form.getPassword();
    		String username = user.getUsername();
    		boolean isEnabled=true;
    		String email= user.getEmail();
    		String street = user.getAddress().getStreet();
    		String zipcode = user.getAddress().getZipcode();
    		String city = user.getAddress().getCity();
            Address address = new Address(street, zipcode, city);
    		List<Role> roles_user = new ArrayList<Role>();
    		String role_user = "ROLE_USER";
    		roles_user.add(new Role(role_user));
    		User updateUser= new User(id,firstname, lastname, username, password, email, isEnabled, address,roles_user);
			service.updateUser(updateUser);
			request.getSession().setAttribute("message", "You have successfully reset your password.");
			 securityContextLogoutHandler.logout(request, response, null);
			return "redirect:/index";
		}
		return "reset-password";
	}
	

	private boolean isValidCookie(Cookie cookie, final String frob)
	{
		return cookie != null && cookie.getValue().equals(frob);
	}
}
