package se.guards.weblayer;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import se.datalayer.guards.service.DisplayImageService;
import se.datalayer.guards.service.UserService;
import se.guard.Address;
import se.guard.UploadImage;
import se.guard.User;

@Controller
@RequestMapping
public class FindUserController
{
	UserService us = new UserService();

	@Autowired
	private static DisplayImageService imgService = new DisplayImageService();

	@RequestMapping(value = "/findSingelUser", method = RequestMethod.GET)
	public String showSearchForm(ModelMap model, SecurityContextHolderAwareRequestWrapper request)
	{
		model.addAttribute("currentUser", getCurrentUsername());
		return "searchUser";
	}

	@RequestMapping(value = "/searchform", method = RequestMethod.GET)
	public String showSearchFormParameter(ModelMap model, SecurityContextHolderAwareRequestWrapper request)
	{
		model.addAttribute("currentUser", getCurrentUsername());
		return "searchByParam";
	}

	@RequestMapping(value = "/findUserById", method = RequestMethod.GET)
	public String searchUserById(@RequestParam("userid") String userId, ModelMap model, SecurityContextHolderAwareRequestWrapper request)
	{
		model.addAttribute("currentUser", getCurrentUsername());
		int userIdFoeImage = Integer.parseInt(userId);
		User foundUserById = us.findUserById(userIdFoeImage);
		UploadImage userImage = imgService.showImageByUserId(userIdFoeImage);
		model.addAttribute("founduserimage", userImage.getImageid());
		model.addAttribute("user", foundUserById);
		return "foundedUser";

	}

	@RequestMapping(value = "/findUserByAnyValue", method = RequestMethod.GET)
	public String searchUser(@RequestParam("anyvalue") String anyvalue, ModelMap model, SecurityContextHolderAwareRequestWrapper request)
	{

		model.addAttribute("currentUser", getCurrentUsername());

		Collection<User> foundUser = us.findUserByASerachString(anyvalue);
		
		model.addAttribute("tokenValues", foundUser);
	

		Collection<User> otherList = new ArrayList<User>();
		if (foundUser != null)
		{

			for (User user : foundUser)
			{
				Address address = new Address(user.getAddress().getStreet(), user.getAddress().getZipcode(), user.getAddress().getCity());
				model.addAttribute("address", address);
				User userDetaile = new User(user.getUserid(), user.getFirstname(), user.getLastname(),user.getCivicregnumber(), user.getUsername(), user.getPassword(), user.getEmail(),
						user.getIsEnabled(), address, user.getRoles());

				otherList.add(userDetaile);
				model.addAttribute("user", userDetaile);
				UploadImage image= imgService.showImageByUserId(userDetaile.getUserid());
				model.addAttribute("image", image.getImageid());
				model.addAttribute("list", otherList);

			}
			
			
			 return "searchByParam";
		}

		else
		{
			model.addAttribute("error", "User dosen't exist");
			return "redirect:/welcome";
		}
	}
	
	private String getCurrentUsername() {
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return obj instanceof UserDetails ? ((UserDetails) obj).getUsername() : obj.toString();
    } 
	

}
