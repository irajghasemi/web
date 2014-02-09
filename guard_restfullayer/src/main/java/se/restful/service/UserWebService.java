package se.restful.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.springframework.web.bind.annotation.ResponseBody;

import se.datalayer.guards.service.UserService;
import se.guard.User;
import se.guard.UserList;
import se.restful.exception.UserNotFoundException;

import com.sun.jersey.api.json.JSONWithPadding;
import com.sun.jersey.spi.resource.Singleton;

@Singleton
@Path("/user")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class UserWebService
{
	@Context
	UriInfo uriInfo;

	private static UserService userService = new UserService();

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public @ResponseBody Response getUser(@PathParam("id") int id) throws Exception
	{

		try
		{
			User user = userService.findUserById(id);
			return Response.ok().entity(user).build();
		}
		catch (Exception e)
		{
			throw new UserNotFoundException(id);

		}
	}
	
	//must use /email/{email} otherwise could get conflict mediaType conflict with getUser method, "lack of jersey" 
	/*
	 * We can not produces and consumes the same mediaType in two different methods if  
	 * */
	@GET
	@Path("/email/{email}")
	@Produces({ MediaType.APPLICATION_JSON})
	@Consumes({ MediaType.APPLICATION_JSON })
	public  Response getUserByEmail(@PathParam("email") String email) throws Exception
	{
		
		try
		{
			User foundeduser = userService.findUserByMail(email);
			return Response.ok().entity(foundeduser).build();
		}
		catch (Exception e)
		{
			throw new UserNotFoundException(email);
			
		}
	}
	@GET
	@Path("/civicregnumber/{civicregnumber}")
	@Produces({ MediaType.APPLICATION_JSON})
	@Consumes({ MediaType.APPLICATION_JSON })
	public  Response getUserByCivicRegistrationNumber(@PathParam("civicregnumber") String civicregnumber) throws Exception
	{
		
		try
		{
			User foundeduser = userService.findUserByCivicRegistraionNumber(civicregnumber);
			return Response.ok().entity(foundeduser).build();
		}
		catch (Exception e)
		{
			throw new UserNotFoundException(civicregnumber);
			
		}
	}
	
	
	@POST
	public @ResponseBody Response addNewUser(User user) throws Exception
	{

		try
		{

			User addingUser = userService.addNewUser(user);
			int id = addingUser.getUserid();
			String addingUserId = Integer.toString(id);
			System.out.println("from webservice: " + addingUserId);
			URI location = UriBuilder.fromPath(addingUserId).build();
			System.out.println("current user from post" + addingUser);
			return Response.created(location).build();
		}
		catch (Exception e)
		{
			return Response.serverError().build();
		}

	}

	@GET
	@Path("/getall")
	@Consumes({ MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public @ResponseBody UserList getAllUser()
	{
	
		

		 return new UserList(new ArrayList<User>(userService.findAllUsers()));

	}
	
	
	@GET
	@Path("/allusers")
	@Consumes({ MediaType.APPLICATION_JSON, "application/x-javascript" })
	@Produces({ MediaType.APPLICATION_JSON, "application/x-javascript" })
	public @ResponseBody
	Collection<User> allUser(@QueryParam("callback") String callback)
	{

		Collection<User> users = userService.findAllUsers();

		return users;

	}

	@GET
	@Path("/jsonp")
	@Produces({ "application/javascript", MediaType.APPLICATION_JSON })
	@Consumes({ "application/javascript", MediaType.APPLICATION_JSON })
	public JSONWithPadding findRangeJsonP(@QueryParam("callback") String callback)
	{
		Collection<User> users = userService.findAllUsers();
		return new JSONWithPadding(new GenericEntity<Collection<User>>(users){}, callback);
	} 

}
