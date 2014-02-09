package se.restful.exception;

public class RepositoryException extends Exception
{

	private static final long serialVersionUID = 4756082790222281857L;

	public RepositoryException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public RepositoryException(String message)
	{
		super(message);
	}

	public RepositoryException(Throwable cause)
	{
		super(cause);
	}
	
	

}
