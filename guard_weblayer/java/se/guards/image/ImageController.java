package se.guards.image;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import se.datalayer.guards.service.DisplayImageService;
import se.datalayer.guards.service.UserService;
import se.guard.UploadImage;
import se.guard.User;

@Controller
@RequestMapping
public class ImageController
{

	@Autowired
	private static DisplayImageService imgService = new DisplayImageService();
	@Autowired
	private static UserService us = new UserService();
	private final int DEFAULT_BUFFER_SIZE = 10000024; // 10KB.

	@RequestMapping(value = "/manageAllImages", method = RequestMethod.GET)
	public String listImages(Model model, HttpServletRequest request)
	{

		String currentUser = request.getUserPrincipal().getName();
		model.addAttribute("currentUser", getCurrentUsername());
		model.addAttribute("image", new UploadImage());

		User user = us.findUserByAnyParameter(currentUser);
		model.addAttribute("user", user);
		
		Collection<UploadImage> imageList = imgService.showAllPictures();
		model.addAttribute("imageList", imageList);

		return "manageallimages";

	}
	
	@RequestMapping(value="/singelImage",method=RequestMethod.GET)
	public String singelUserImage(@RequestParam("userid") String user_id,Model model, HttpServletRequest requet){
		
		model.addAttribute("currentUser", getCurrentUsername());
		int userId_forImage= Integer.parseInt(user_id);
		User user= us.findUserById(userId_forImage);
		model.addAttribute("user", user);
		UploadImage userImage= imgService.showImageByUserId(userId_forImage);
		model.addAttribute("founduserimage", userImage.getImageid());
		
		return "singelImage";
	}
	
	
	@RequestMapping(value = "/oneImage", method = RequestMethod.GET)
    public String currentUserImage(Model model, HttpServletRequest request)
    {
            
            String currentUser = request.getUserPrincipal().getName();
            model.addAttribute("currentUser", getCurrentUsername());
            
            User user = us.findUserByAnyParameter(currentUser);
            model.addAttribute("user", user);
            
            model.addAttribute("image", new UploadImage());
            UploadImage image= imgService.showImageByUserId(user.getUserid());
            model.addAttribute("currentuserimage", image);
            
            return "oneImage";
            
    }

	@RequestMapping(value = "/image/{id}", method = RequestMethod.GET)
	public void getImage(@PathVariable("id") int imageid, HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException
	{

		if (imageid <= 0)
		{
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		UploadImage image = imgService.showImageByImageId(imageid);

		File img = new File(image.getFilePath());

		response.reset();
		response.setBufferSize(DEFAULT_BUFFER_SIZE);
		response.setContentType(image.getContetnttype());
		response.setHeader("Content-Length", String.valueOf(img.length()));
		response.setHeader("Content-Disposition", "inline; filename=\"" + image.getFileName() + "\"");

		BufferedInputStream input = null;
		BufferedOutputStream output = null;

		try
		{
			// Open streams.
			input = new BufferedInputStream(new FileInputStream(img), DEFAULT_BUFFER_SIZE);
			output = new BufferedOutputStream(response.getOutputStream(), DEFAULT_BUFFER_SIZE);

			// Write image to response.
			byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
			int length;
			while ((length = input.read(buffer)) > 0)
			{
				output.write(buffer, 0, length);
			}
		}
		finally
		{
			// Close streams.
			output.close();
			input.close();
		}

	}
	
	private String getCurrentUsername() {
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return obj instanceof UserDetails ? ((UserDetails) obj).getUsername() : obj.toString();
    } 

}
