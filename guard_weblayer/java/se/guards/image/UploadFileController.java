package se.guards.image;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.BindException;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import se.datalayer.guards.service.ImageUploadService;
import se.datalayer.guards.service.ResizeBufferedImageService;
import se.datalayer.guards.service.UserService;
import se.guard.UploadImage;
import se.guard.User;

@Controller
@RequestMapping(value = "/uploadfile")
public class UploadFileController
{
	private String uploadFolderPath;
	ServletConfig config;

	private static UploadImage uploadImage = new UploadImage();
	private static ImageUploadService imgservice = new ImageUploadService();
	private static UserService userService = new UserService();
	private static ResizeBufferedImageService resizeAndSaveImage = new ResizeBufferedImageService();

	public String getUploadFolderPath()
	{
		return uploadFolderPath;
	}

	public void setUploadFolderPath(String uploadFolderPath)
	{
		this.uploadFolderPath = uploadFolderPath;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getUploadForm(Model model)
	{
		model.addAttribute("currentUser",getCurrentUsername() );
		UploadImage uploadImage = new UploadImage();
		model.addAttribute(uploadImage);
		return "/uploadfile";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String create(@ModelAttribute("uploadImage") UploadImage up, HttpServletRequest request, HttpServletResponse response, ModelMap model, BindException errors,
			HttpSession session)
	{

		String destinationDIR = "/Users/iraj/myfiles/uploaded/";

		String userlogin = request.getUserPrincipal().getName();

		User loggedin_User = userService.findUserByAnyParameter(userlogin);

		model.addAttribute("currentUser", loggedin_User.getFirstname());

		if (userService.doUserExist(loggedin_User))
		{

			try
			{

				MultipartFile fileToUpload = up.getFileData();

				InputStream inputStream = null;
				OutputStream outputStream = null;
				if (fileToUpload.getSize() != 0)
				{

					inputStream = fileToUpload.getInputStream();
					String firstname = loggedin_User.getFirstname();
					String lastname = loggedin_User.getLastname();
					String imageName = firstname.toUpperCase() + "-" + lastname.toUpperCase() + ".png";
					String writeFileWithName = destinationDIR + imageName;
					String filepathToDadatbae = destinationDIR+ imageName ;
					String contenttype = fileToUpload.getContentType();

					outputStream = new FileOutputStream(writeFileWithName);

					String name_Of_Resized_Image = destinationDIR + firstname.toUpperCase() + "-" + lastname.toUpperCase();
					resizeAndSaveImage.saveResizedImageAsBufferedImage(inputStream, name_Of_Resized_Image);
					uploadImage = new UploadImage(imageName, filepathToDadatbae, contenttype,loggedin_User);

					imgservice.relativPathDB(uploadImage);
					outputStream.close();
					inputStream.close();

					model.addAttribute("username", firstname);
					session.setAttribute("success", "File Uploaded Successfully");
					session.setAttribute("uploadFile", "/Users/iraj/myfiles/uploaded/" + uploadImage.getFileName());
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			// return "redirect:/userimage";
			return "redirect:/uploadfileindex";
		}
		else
		{
			return "redirect:/index";

		}
	}

	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public String accessDenied()
	{

		return "403";
	}
	
	private String getCurrentUsername() {
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return obj instanceof UserDetails ? ((UserDetails) obj).getUsername() : obj.toString();
    } 
	
}