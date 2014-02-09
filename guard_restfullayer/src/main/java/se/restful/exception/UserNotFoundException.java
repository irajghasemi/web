package se.restful.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class UserNotFoundException extends WebApplicationException
{

	private static final long serialVersionUID = 534044898356964425L;

	public UserNotFoundException(int id)
	{
		super(id);
	}
	
	public UserNotFoundException(Throwable cause,String email)
	{
		super();
	}

	public UserNotFoundException(Status status)
	{
		super(status);
	}

	

	public UserNotFoundException(Throwable cause, int id)
	{
		super(cause, id);
	}
	

	public UserNotFoundException(Throwable cause)
	{
		super(cause);
	}

	public UserNotFoundException(Long userId)
	{
		super(Response.status(Status.NOT_FOUND).entity("User with id: "+userId+" could not be found").build());
	}
	public UserNotFoundException(String query)
	{
		super(Response.status(Status.NOT_FOUND).entity("User with email: "+query+" could not be found").build());
	}

	public UserNotFoundException(Throwable cause, Status status)
	{
		super(cause, status);
	}
	

	

}
