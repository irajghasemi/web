package se.restful.provider;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.WeakHashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import se.guard.User;
import se.restful.serializer.UserTypeAdapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Provider
@Consumes({ MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
public class UserJsonProvider implements MessageBodyReader<User>, MessageBodyWriter<User>
{
	@SuppressWarnings("rawtypes")
	static Map<Class, JAXBContext> jaxbContexts = new WeakHashMap<Class, JAXBContext>();
	private Gson gson;

	public UserJsonProvider()
	{
		gson = new GsonBuilder().registerTypeAdapter(User.class, new UserTypeAdapter()).create();
	}

	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType)
	{
		return User.class.isAssignableFrom(type);
	}

	@Override
	public long getSize(User t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType)
	{
		return -1;
	}

	@Override
	public void writeTo(User user, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders,
			OutputStream entityStream) throws IOException, WebApplicationException
	{

		entityStream.write(gson.toJson(user).getBytes());
	}

	@Override
	public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType)
	{
		return User.class.isAssignableFrom(type);
	}

	@Override
	public User readFrom(Class<User> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> httpHeaders,
			InputStream entityStream) throws IOException, WebApplicationException
	{
		return gson.fromJson(new InputStreamReader(entityStream), User.class);
	}
	
	@SuppressWarnings({ "rawtypes", "unused" })
	private JAXBContext getJAXBContext(Class type) throws JAXBException {
        synchronized (jaxbContexts) {
            JAXBContext context = jaxbContexts.get(type);
            if (context == null) {
                context = JAXBContext.newInstance(type);
                jaxbContexts.put(type, context);
            }
            return context;
        }
    }

}
