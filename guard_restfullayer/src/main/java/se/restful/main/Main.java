package se.restful.main;

import java.io.IOException;
import java.util.Collection;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import se.datalayer.guards.service.UserService;
import se.guard.Address;
import se.guard.User;

import com.google.gson.Gson;

public class Main
{

	public static void main(String[] args)
	{
		// getUsers();
//		 getAllUsers();
		getUserByEmail();
//		addNewUser();
//		generatePassword();
//		System.out.println(encodePasswordWithBCrypt("min"));
//		generatePassword();
		
	}

	public static UserService userService = new UserService();
	
	
	public static String encodePasswordWithBCrypt(String plainPassword){
	    return new BCryptPasswordEncoder().encode(plainPassword);
	}
	
	
	public static void  generatePassword(){
		
		User user=userService.findUserByPassword("min");
//		BCryptPasswordEncoder hash= new BCryptPasswordEncoder();
//		String hashedPassword=hash.encode(user.getPassword());
		
		User updateUser=new User(user.getUserid(), user.getFirstname(), user.getLastname(), user.getEmail(), encodePasswordWithBCrypt(user.getPassword()));
		userService.updateUser(updateUser);
	}

	public static void addNewUser()
	{

		Address address=new Address("jackob"," 12345", "stock");
		User user= new User(20,"shervin", "shervinoff", "shervinname", encodePasswordWithBCrypt("adrian"), "shervin@shervin.com", true, address);
		

		userService.addNewUser(user);

	}

	public static void getUsers()
	{

		User user = userService.findUserById(1);

		Gson gson = new Gson();

		System.out.println(gson.toJson(user));

	}

	public static void getAllUsers()
	{

		Collection<User> users= userService.findAllUsers();
		ObjectMapper mapper = new ObjectMapper();
		
		for (User user : users)
		{
			try
			{
				System.out.println(mapper.defaultPrettyPrintingWriter().writeValueAsString( user ));
			}
			catch (JsonGenerationException e)
			{
				e.printStackTrace();
			}
			catch (JsonMappingException e)
			{
				e.printStackTrace();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}

	}
	public static void getUserByEmail() 
	{
		
		User user=userService.findUserByMail("iraj@zas.se");
		System.out.println(user );
//ObjectMapper map= new ObjectMapper();
//		try
//		{
//			map.defaultPrettyPrintingWriter().withDefaultPrettyPrinter().writeValueAsString(user);
//			System.out.println(map.defaultPrettyPrintingWriter().withDefaultPrettyPrinter().writeValueAsString(user));
//		}
//		catch (JsonGenerationException e)
//		{
//			e.printStackTrace();
//		}
//		catch (JsonMappingException e)
//		{
//			e.printStackTrace();
//		}
//		catch (IOException e)
//		{
//			e.printStackTrace();
//		}
	}

}
