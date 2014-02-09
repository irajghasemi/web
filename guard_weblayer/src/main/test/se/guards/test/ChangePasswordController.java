package se.guards.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.memory.InMemoryDaoImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChangePasswordController 
{
	
	IChangePassword changePasswordDao;
	
	@RequestMapping(value="/changePassword",method=RequestMethod.GET)
			public void showChangePasswordPage() {
			}
	
	@RequestMapping(value="/changePassword",method=RequestMethod.POST)
			public String submitChangePasswordPage(@RequestParam("password")
			String newPassword) {
		
		Object principal= SecurityContextHolder.getContext().getAuthentication().getDetails();
		String username=principal.toString();
		if(principal instanceof UserDetails){
			username=((UserDetails) principal).getUsername();
		}
		changePasswordDao.changePassword(username, newPassword);
		SecurityContextHolder.clearContext();
		return "redirect:index";
	}

		
	

}
