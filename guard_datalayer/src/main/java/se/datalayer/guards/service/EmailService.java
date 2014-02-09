package se.datalayer.guards.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import se.datalayer.guards.repository.EmailRepository;

@Service
public class EmailService implements EmailRepository
{
	@PersistenceContext(unitName = "emailService")
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("guards");
	@PersistenceContext(unitName = "emailService")
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	
	@Autowired
	public static JavaMailSenderImpl mailSender= new JavaMailSenderImpl();

	public void sendDemoMail(String emailId) throws MessagingException {

		MimeMessage message = null;
		MimeMessageHelper helper = null;
		try {
			message = mailSender.createMimeMessage();
			helper = new MimeMessageHelper(message);
			helper.setTo(emailId);
			helper.setSubject("Test Subject");
			helper.setText("Test Mail");
			mailSender.send(message);

		} catch (MessagingException me) {
			System.out.println("Exception in sendMailDemo");
			throw me;
		}

	}
	
}
