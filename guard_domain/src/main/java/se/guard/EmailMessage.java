package se.guard;


public class EmailMessage
{

	private String receiverEmailAddress;
	

	public EmailMessage()
	{
	}

	public EmailMessage(String receiverEmailAddress)
	{
		this.receiverEmailAddress = receiverEmailAddress;
		
	}

	

	public void setReceiverEmailAddress(String receiverEmailAddress)
	{

		this.receiverEmailAddress = receiverEmailAddress;
	}

	public String getReceiverEmailAddress()
	{

		return this.receiverEmailAddress;
	}

	

	@Override
	public String toString()
	{
		return "receiverEmailAddress=" + receiverEmailAddress ;
	}

}
