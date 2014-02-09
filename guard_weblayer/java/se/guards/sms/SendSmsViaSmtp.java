package se.guards.sms;

import java.util.Date;
import java.util.Properties;
 
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class SendSmsViaSmtp {
 
	/**
	 * @param args
	 * @throws MessagingException 
	 * @throws AddressException 
	 */
	public static void main(String[] args) throws AddressException, MessagingException {
		SendSmsViaSmtp smtpSend = new SendSmsViaSmtp();
		smtpSend.msgsend();
	}
 
	/**
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public void msgsend() throws AddressException, MessagingException {
		String username = "iraj@zas.se";
		String password = "golestan";
		String smtphost = "smtp.bredband.net";
		String compression = ""; // insert compression option here if desired
		String from = "iraj@zas.se";
		String to = "0046707313330@zas.se";
		String body = "Your Message";
		Transport tr = null;
 
		Properties props = System.getProperties();
		props.put("mail.smtp.auth", "true");
 
		// Get a Session object
		Session mailSession = Session.getDefaultInstance(props, null);
 
		// construct the message
		Message msg = new MimeMessage(mailSession);
 
		// Set message attributes
		msg.setFrom(new InternetAddress(from));
		InternetAddress[] address = { new InternetAddress(to) };
		msg.setRecipients(Message.RecipientType.TO, address);
		msg.setSubject(compression);
		msg.setText(body);
		msg.setSentDate(new Date());
 
		tr = mailSession.getTransport("smtp");
		tr.connect(smtphost, username, password);
		msg.saveChanges();
		tr.sendMessage(msg, msg.getAllRecipients());
		tr.close();
	}
}