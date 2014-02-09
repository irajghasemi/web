package se.restful.serializer;



import java.lang.reflect.Type;

import se.guard.User;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class UserTypeAdapter implements JsonSerializer<User>, JsonDeserializer<User>
{

	@Override
	public User deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
	{
		final JsonObject jsonObject = json.getAsJsonObject();

		int id = -1;

		if (jsonObject.has("id"))
		{
			id = jsonObject.get("id").getAsInt();
		}
		
//		int id = jsonObject.get("userid").getAsInt();
		String firstname = jsonObject.get("firstname").getAsString();
		String lastname = jsonObject.get("lastname").getAsString();
		String email= jsonObject.get("email").getAsString();
		String password= jsonObject.get("password").getAsString();
		User user= new User(id, firstname, lastname, email, password);
		return user;
	}

	@Override
	public JsonElement serialize(User src, Type typeOfSrc, JsonSerializationContext context)
	{
		JsonObject userAsJson= new JsonObject();
		userAsJson.addProperty("userid", src.getUserid());
		userAsJson.addProperty("firstname", src.getFirstname());
		userAsJson.addProperty("lastname", src.getLastname());
		userAsJson.addProperty("email", src.getEmail());
		userAsJson.addProperty("password", src.getPassword());
		
		return userAsJson;
	}

}
