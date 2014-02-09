package se.datalayer.guards.repository;

import javax.mail.MessagingException;

import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository
{
	
	void sendDemoMail(String emailAddress) throws MessagingException;
}
