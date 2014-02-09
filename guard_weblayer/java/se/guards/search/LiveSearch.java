package se.guards.search;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import se.datalayer.guards.service.AdminCalendarService;
import se.datalayer.guards.service.ChooseGuardDutyService;
import se.datalayer.guards.service.DisplayImageService;
import se.datalayer.guards.service.UserService;
import se.guard.ChooseGuardDuty;
import se.guard.UploadImage;
import se.guard.User;
import se.guard.UserList;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@Controller
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public class LiveSearch
{
	@Autowired
	private static DisplayImageService imgService = new DisplayImageService();
	@Autowired
	private static UserService us = new UserService();
	
	@Autowired
	private static AdminCalendarService dateService = new AdminCalendarService();

	@Autowired
	private static ChooseGuardDutyService guardDutyService = new ChooseGuardDutyService();

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public String test(@QueryParam("callback") String callback, ModelMap model, HttpServletRequest request)
	{

		UserList list = new UserList(new ArrayList<User>(us.findAllUsers()));
		Collection<User> users = us.findAllUsers();

		for (User user : users)
		{
			int userid= user.getUserid();
			model.addAttribute("userid", userid);
		}

		Gson g = new Gson();

		Object gg = g.toJson(list);
		model.addAttribute("users", users);

		model.addAttribute("search", gg);

		return "search";
	}

	@RequestMapping(value = "/buttons", method = RequestMethod.GET)
	public String buttons()
	{

		return "buttons";
	}

	@RequestMapping(value = "/userCalendar", method = RequestMethod.GET)
	public String userCalendar(ModelMap model, SecurityContextHolderAwareRequestWrapper request)
	{
		model.addAttribute("currentUser", getCurrentUsername());

		return "userCalendar";
	}

	@RequestMapping(value = "/asjson", method = RequestMethod.GET)
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public String getAsJson(ModelMap model, HttpServletRequest request)
	{
		Client client = Client.create();
		WebResource service = client.resource(getBaseURI());
		String userAsJson = service.path("user/getall").accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).get(String.class);

		model.addAttribute("json", userAsJson);

		return "asjson";

	}
	@RequestMapping(value = "/searchByEmailAddress", method = RequestMethod.GET)
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public String serachByEmailAddress(ModelMap model, HttpServletRequest request)
	{
		Client client = Client.create();
		WebResource service = client.resource(getBaseURI());
		ClientResponse userAsJson = service.path("user/email").accept(MediaType.APPLICATION_XML).type(MediaType.APPLICATION_XML).get(ClientResponse.class);
		
		model.addAttribute("json", userAsJson);
		
		return "searchByEmailAddress";
		
	}
	@RequestMapping(value = "/searchByCivicRegNumber", method = RequestMethod.GET)
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public String serachByCivicRegNumber(ModelMap model, HttpServletRequest request)
	{
		Client client = Client.create();
		WebResource service = client.resource(getBaseURI());
		ClientResponse userAsJson = service.path("user/civicregnumber").accept(MediaType.APPLICATION_XML).type(MediaType.APPLICATION_XML).get(ClientResponse.class);
		
		model.addAttribute("json", userAsJson);
		
		return "searchByCivicRegNumber";
		
	}

	@RequestMapping(value = "/liveSearch", method = RequestMethod.GET)
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public String liveSearch(ModelMap model, HttpServletRequest request, SecurityContextHolderAwareRequestWrapper sec)
	{
		model.addAttribute("currentUser", getCurrentUsername());

		Collection<User> users = us.findAllUsers();
		model.addAttribute("allUsers", users);

		Collection<UploadImage> imageList = imgService.showAllPictures();
		model.addAttribute("imageList", imageList);
		return "liveSearch";

	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
//	@Consumes({ MediaType.APPLICATION_JSON })
//	@Produces({ MediaType.APPLICATION_JSON })
	public String test(ModelMap model, HttpServletRequest request, SecurityContextHolderAwareRequestWrapper sec)
	{
		Collection<User> users= us.findAllUsers();
		model.addAttribute("users", users);
		Collection<ChooseGuardDuty> guards= guardDutyService.getAllPickedDates();
		model.addAttribute("currentUser", getCurrentUsername());
		Collection<User> list = us.findAllUsers();
		model.addAttribute("allUsers", list);
		model.addAttribute("guards", guards);
		
		Client client = Client.create();
		WebResource service = client.resource(getBaseURI());
		ClientResponse userAsJson = service.path("user/allusers").accept(MediaType.APPLICATION_XML).type(MediaType.APPLICATION_XML).get(ClientResponse.class);
		
		model.addAttribute("json", userAsJson);
		
		return "test";
		
	}
	@RequestMapping(value = "/userListRest", method = RequestMethod.GET)
//	@Consumes({ MediaType.APPLICATION_JSON })
//	@Produces({ MediaType.APPLICATION_JSON })
	public String UserListRest(@QueryParam("callback") String callback,ModelMap model, HttpServletRequest request)
	{
		
		return "userListRest";
		
	}
	
	private static URI getBaseURI()
	{
		return UriBuilder.fromUri("http://localhost:8080/guard_restfullayer/").build();
	}
	
	private String getCurrentUsername() {
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return obj instanceof UserDetails ? ((UserDetails) obj).getUsername() : obj.toString();
    } 

}
