package se.guards.velocitymail;

import java.util.Collection;

import javax.mail.internet.AddressException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import se.datalayer.guards.service.EmailService;
import se.datalayer.guards.service.UserService;
import se.guard.EmailMessage;
import se.guard.User;
import se.guards.lostpassword.LostPasswordForm;
import se.guards.security.BCrypt;




@Controller
public class EmailController
{
	private static final Logger logger = LoggerFactory.getLogger(EmailController.class);

	@Autowired(required=false)
	private static UserService us = new UserService();

	@Autowired(required=false)
	public VelocityEmailService sender;
	
	public static String URL="http://localhost:8080/guard_weblayer/password/reset?frob=";

	@RequestMapping(value = "/recover", method = RequestMethod.GET)
	public String getIndex(ModelMap model)
	{
		model.addAttribute("emailAddress", new EmailService());
		return "index";
	}
	
	@ModelAttribute("form")
	public LostPasswordForm populateForm()
	{
		return new LostPasswordForm();
	}
	
	@RequestMapping(value = "/sendemail", method = RequestMethod.POST)
	public String sendEmailByVelocity(@ModelAttribute("form") LostPasswordForm form,ModelMap model, HttpServletRequest request, HttpServletResponse response, ModelAndView modelView)
			throws AddressException
	{
		
//		//Get a ","  before email in the form for removing it using delimiter
		String delimiter = ",";
		String out=null;
		  /* given string will be split by the argument delimiter provided. */
		 String[] temp = form.getEmail().split(delimiter);
		  /* print substrings */
		    for(int i =0; i < temp.length ; i++)
		    	 out=temp[i];
		logger.debug("Processing lost password form.");
		
		Collection<User> getUser= us.findUserByASerachString(out);
		for (User user : getUser)
		{
			System.out.println(user);
		
            if (user != null)
			{
				String frob = BCrypt.hashpw(user.getUsername() + "3m4il", BCrypt.gensalt());
				String link = createLostPasswordLink(user, frob);
				response.addCookie(persistFrob(frob));
				//model for the *.vm 
				modelView.addObject("user", user);
				//model for the *.jsp 
				model.addAttribute("userModel", user);
				sender.sendLostPasswordEmail(user, link);
				return "emailSended";
			}
		}
            return "redirect:/emailSended";
	}

	
	
	
	@RequestMapping(value = "/sendEmail", method = RequestMethod.GET)
	public String getPassword(ModelMap model)
	{
		model.addAttribute("sended", new EmailMessage());
		return "sendEmail";
	}

	private String createLostPasswordLink(final User user, final String frob)
	{
		StringBuilder link = new StringBuilder();
        link.append(URL);
        link.append(frob);
        link.append("&username=");
        link.append(user.getUsername());
		return link.toString();
	}

	private Cookie persistFrob(final String frob)
	{
		
		Cookie cookie = new Cookie("frob", frob);
		cookie.setMaxAge(60 * 60); // 1 hour
		return cookie;
	}
	

}
