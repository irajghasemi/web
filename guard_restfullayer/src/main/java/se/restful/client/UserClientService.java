package se.restful.client;

import java.net.URI;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.apache.commons.lang3.StringUtils;

import se.guard.User;
import se.restful.provider.UserJsonProvider;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class UserClientService
{
	private final Client client;
	private final String baseUri;

	public UserClientService(String baseUri)
	{
		this.baseUri = baseUri;
		this.client = Client.create(new DefaultClientConfig(UserJsonProvider.class));
	}

	public String addUser(final User user)
	{

		URI location = client.resource(baseUri).type(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_XML).post(ClientResponse.class, user).getLocation();

		return getIdFromLocation(location);
	}

	public User getUser(String id)
	{

		ClientResponse response = client.resource(UriBuilder.fromUri(baseUri).path(id).build()).get(ClientResponse.class);

		if (response.getClientResponseStatus() == ClientResponse.Status.OK)
		{
			return response.getEntity(User.class);

		}
		else
		{

			return null;
		}
	}
	
	
	public User getUserByEmail(String email){
		
		ClientResponse response = client.resource(UriBuilder.fromUri(baseUri).path(email).build()).get(ClientResponse.class);

		if (response.getClientResponseStatus() == ClientResponse.Status.OK)
		{
			return response.getEntity(User.class);

		}
		else
		{

			return null;
		}
	}


	
	public List<User> getAllUsers()
	{
		ClientResponse response = client.resource(UriBuilder.fromUri(baseUri).path("user/getall").build()).get(ClientResponse.class);
		

		 if (response.getClientResponseStatus() == ClientResponse.Status.OK)
		 {
			 List<User> users = response.getEntity(new GenericType<List<User>>(){});
			 return users;
			 // return response.getEntity(User.class);
		
		 }
		 else
		 {
		
		 return null;
		 }

	}


	public void updateUser(User user)
	{
		String id = user.getUserid() + "";
		client.resource(UriBuilder.fromUri(baseUri).path(id).build()).type(MediaType.APPLICATION_JSON).put(user);
	}

	private String getIdFromLocation(final URI uri)
	{
		return StringUtils.substringAfterLast(uri.getPath(), "/");
	}

}
