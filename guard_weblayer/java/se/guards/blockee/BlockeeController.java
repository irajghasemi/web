package se.guards.blockee;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import se.datalayer.guards.service.BlockeeService;
import se.datalayer.guards.service.DisplayImageService;
import se.datalayer.guards.service.UserService;
import se.guard.Blockee;
import se.guard.UploadImage;
import se.guard.User;

@Controller
@RequestMapping
public class BlockeeController
{
	@Autowired
	private static BlockeeService blockeeService = new BlockeeService();
	@Autowired
	private static UserService us = new UserService();
	@Autowired
	private static DisplayImageService imgService = new DisplayImageService();

	
	@RequestMapping(value = "/showBlockee", method = RequestMethod.GET)
	public String blockee(ModelMap model, HttpServletRequest request, HttpServletResponse response)
	{
		model.addAttribute("currentUser", getCurrentUsername());

		Collection<Blockee> allBlockees = blockeeService.showBlockee();
		model.addAttribute("blockees", allBlockees);

		Collection<User> allusers = us.findAll();
		model.addAttribute("users", allusers);

		return "blockeeIndex";
	}
	

	@RequestMapping(value = "/showAllBlockee", method = RequestMethod.GET)
	public String showAlluserForBlockee(ModelMap model, HttpServletRequest request, HttpServletResponse response)
	{

		return "blockeeIndex";
	}

	@RequestMapping(value = "/deleteBlockee", method = RequestMethod.GET)
	public String deleteFromBlockee(@RequestParam("blockeeid") String blocker_id, ModelMap model)
	{
		model.addAttribute("currentUser", getCurrentUsername());
		int blockeid = Integer.parseInt(blocker_id);
		Blockee blockee = blockeeService.findBlockee_ByBlockeeId(blockeid);
		blockeeService.deleteUserFromBlockee(blockee);

		return "/blockeeIndex";
	}


	@RequestMapping(value = "/autocomplete", method = RequestMethod.GET)
	public String autocomplete(ModelMap model, HttpServletRequest request, SecurityContextHolderAwareRequestWrapper sec)
	{

		model.addAttribute("currentUser", getCurrentUsername());

		Collection<User> users = us.findAllUsers();
		model.addAttribute("allUsers", users);

		Collection<UploadImage> imageList = imgService.showAllPictures();
		model.addAttribute("imageList", imageList);

		return "autocomplete";

	}
	

	@RequestMapping(value = "/autocomplete", method = RequestMethod.POST)
	public String blockeeImages(@RequestParam("userid") String blocker, @RequestParam("userid") String blocked, Model model)
	{

		model.addAttribute("currentUser", getCurrentUsername());

		int blockerId = Integer.parseInt(blocker);
		User blockerUser = us.findUserById(blockerId);
		model.addAttribute("user", blockerUser);
		UploadImage blockerImage = imgService.showImageByUserId(blockerId);
		model.addAttribute("blockerImage", blockerImage.getImageid());

		int blockedid = Integer.parseInt(blocked);
		User blockedUser = us.findUserById(blockedid);
		model.addAttribute("blockedUser", blockedUser);
		UploadImage blockedImage = imgService.showImageByUserId(blockedid);
		model.addAttribute("blockedImage", blockedImage.getImageid());
		
		Blockee blockee= new Blockee(blockerUser,blockedUser);
		blockeeService.addUserToBlockee(blockee);

		return "/blockeeIndex";
	}
	

	private String getCurrentUsername()
	{
		Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return obj instanceof UserDetails ? ((UserDetails) obj).getUsername() : obj.toString();
	}

}
