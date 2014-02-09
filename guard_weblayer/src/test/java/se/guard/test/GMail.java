package se.guard.test;

import java.io.UnsupportedEncodingException;
	import java.util.Properties;
	import javax.mail.Message;
	import javax.mail.MessagingException;
	import javax.mail.Session;
	import javax.mail.Transport;
	import javax.mail.internet.InternetAddress;
	import javax.mail.internet.MimeMessage;

public class GMail {

    public static void sendMail(String senderEmail, String recipientEmail, String subject, String message) throws MessagingException, UnsupportedEncodingException {
        // TLS
        Properties propsTLS = new Properties();
        propsTLS.put("mail.transport.protocol", "smtp");
        propsTLS.put("mail.smtp.host", "smtp.gmail.com");
        propsTLS.setProperty("mail.smtp.ssl.trust", "smtpserver");
        propsTLS.put("mail.smtp.auth", "true");
        propsTLS.put("mail.smtps.auth", "true");
        propsTLS.put("mail.smtp.starttls.enable", "true"); // GMail requires STARTTLS
        Session sessionTLS = Session.getInstance(propsTLS);
        sessionTLS.setDebug(true);

        Message messageTLS = new MimeMessage(sessionTLS);
        messageTLS.setFrom(new InternetAddress("j10mehdig@gmail.com", "golestan42"));
        messageTLS.setRecipients(Message.RecipientType.TO, InternetAddress.parse("j10mehdig@gmail.com")); // real recipient
        messageTLS.setSubject("Test mail using TLS");
        messageTLS.setText("This is test email sent to Your account using TLS.");

        Transport transportTLS = sessionTLS.getTransport();
        transportTLS.connect("smtp.gmail.com", 465, "j10mehdig@gmail.com", "golestan42"); // account used
        transportTLS.sendMessage(messageTLS, messageTLS.getAllRecipients());
        transportTLS.close();

        System.out.println("TLS done.");
        System.out.println("------------------------------------------------------------------------");

        // SSL			
        Properties propsSSL = new Properties();
        propsSSL.put("mail.transport.protocol", "smtps");
        propsSSL.put("mail.smtps.host", "smtp.gmail.com");
        propsSSL.put("mail.smtps.auth", "true");

        Session sessionSSL = Session.getInstance(propsSSL);
        sessionSSL.setDebug(true);

        Message messageSSL = new MimeMessage(sessionSSL);
        messageSSL.setFrom(new InternetAddress("j10mehdig@gmail.com", "golestan42"));
        messageSSL.setRecipients(Message.RecipientType.TO, InternetAddress.parse("j10mehdig@gmail.com")); // real recipient
        messageSSL.setSubject("Test mail using SSL");
        messageSSL.setText("This is test email sent to Your account using SSL.");

        Transport transportSSL = sessionSSL.getTransport();
        transportSSL.connect("smtp.gmail.com", 465, "j10mehdig@gmail.com", "golestan42"); // account used
        transportSSL.sendMessage(messageSSL, messageSSL.getAllRecipients());
        transportSSL.close();

        System.out.println("SSL done.");
        System.out.println("------------------------------------------------------------------------");

    }

    public static void main(String[] args) throws MessagingException, UnsupportedEncodingException {
        System.out.println("Hello World!");
        sendMail("j10mehdig@gmail.com","iraj@zas.se", "test", "provar om det funkar att skicka mail");
    }
}

