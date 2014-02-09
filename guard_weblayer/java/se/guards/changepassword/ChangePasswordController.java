package se.guards.changepassword;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import se.datalayer.guards.service.UserService;
import se.guard.Address;
import se.guard.Role;
import se.guard.User;

@Controller
public class ChangePasswordController {

    private static final Logger logger = LoggerFactory.getLogger(ChangePasswordController.class);
    
    @Autowired(required=false)
    UserService service= new UserService();

    @ModelAttribute("form")
    public ChangePasswordForm populateForm(HttpServletRequest request) {
        return new ChangePasswordForm();
    }

    @RequestMapping(value = "/changePassword", method = GET)
    public String changePassword() {
        logger.debug("Rendering change password form.");
        return "change-password";
    }

    @RequestMapping(value = "/changePassword", method = POST)
    public String processSubmit(HttpServletRequest request, @ModelAttribute("form") ChangePasswordForm form, BindingResult result,HttpServletResponse response) {
        logger.debug("Processing change password form.");
        User user = service.findUserByAnyParameter(getCurrentUsername());
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        new ChangePasswordFormValidator(user).validate(form, result);
        if (!result.hasErrors()) {
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
            
            request.getSession().setAttribute("message", "You have successfully changed your password.");
            securityContextLogoutHandler.logout(request, response, null);
            return "redirect:/logout";
        }
        return "change-password";
    }

    private String getCurrentUsername() {
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return obj instanceof UserDetails ? ((UserDetails) obj).getUsername() : obj.toString();
    }
    
    public static String encodePasswordWithBCrypt(String plainPassword)
	{

		return new BCryptPasswordEncoder().encode(plainPassword);
	}

}
  