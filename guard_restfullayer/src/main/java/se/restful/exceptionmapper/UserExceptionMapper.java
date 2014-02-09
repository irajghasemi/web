package se.restful.exceptionmapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import se.restful.exception.RepositoryException;

public class UserExceptionMapper implements ExceptionMapper<RepositoryException>
{

	@Override
	public Response toResponse(RepositoryException exception)
	{
		return Response.status(Status.BAD_REQUEST).entity(exception.getMessage()).build();
	}

	

}
