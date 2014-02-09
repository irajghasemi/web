package se.restful.mainforclient;



import java.net.URI;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import se.datalayer.guards.service.UserService;
import se.guard.User;
import se.restful.client.UserClientService;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ClientMain
{

	public static void main(String[] args)
	{
//		addUserClient();
//		testJerseyClient("1");
//		getUserClient();
//		getAllUser();
	}

	private static String location = "http://localhost:8080/guard_restfullayer/";
	private static UserService userService = new UserService();

	public static void testJerseyClient(String userId)
	{
//		ClientConfig cc = new DefaultClientConfig();
		Client client = Client.create();
//		WebResource service = client.resource(getBaseURI()+userId);

		// Create WebResource
		WebResource resource = client.resource("http://localhost:8080/guard_restfullayer/user/" + userId);

		// Execute HTTP get request against that resource
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

		// Get response body as a string
		String jsonData = response.getEntity(String.class);

		// Create a JSON parser that can parse the string with JSON data
		JsonParser parser = new JsonParser();

		// Parse the data into a JSON object
		JsonObject json = parser.parse(jsonData).getAsJsonObject();

		// Retrieve property values from the JSON object
		System.out.println(json.get("userid").getAsInt());
		System.out.println(json.get("firstname").getAsString());
		System.out.println(json.get("lastname").getAsString());
		System.out.println(json.get("email").getAsString());
		System.out.println(json.get("password").getAsString());

	}

	
	@SuppressWarnings("unused")
	public static void getUserClient()
	{
		Client client = Client.create();
		WebResource service = client.resource(getBaseURI());
		UserClientService userClientService = new UserClientService(location);
		User user = userService.findUserById(1);
		String idd=Integer.toString(user.getUserid());
		String userAsJson = service.path("user/").path(idd).accept(MediaType.APPLICATION_JSON).get(String.class);
		String userAsXml = service.path("user/").path(idd).accept(MediaType.APPLICATION_XML).get(String.class);
		System.out.println(userAsJson);
		System.out.println(userAsXml);
//		User user1 = userClientService.getUser(idd);
//		System.out.println("from user client: "+user1);

	}
	
	
	public static void getAllUser(){
//		Client client = Client.create();
//		WebResource service = client.resource(getBaseURI());
//		UserClientService userClientService = new UserClientService(location);
//		userClientService.getAllUsers();
//		String userAsJson = service.path("user/").path("getall").accept(MediaType.APPLICATION_JSON).get(String.class);
//		System.out.println(userAsJson);
		UserClientService userClientService = new UserClientService("http://localhost:8080/guard_restfullayer/user");
		List<User> users= userClientService.getAllUsers();
		System.out.println(users);
		
	}
	
	private static URI getBaseURI() {
	    return UriBuilder.fromUri("http://localhost:8080/guard_restfullayer/").build();
	  }

}
