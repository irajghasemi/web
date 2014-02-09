package se.guard.test;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class GMailClient extends Authenticator {

    // Edit these settings with your username and password
    private String gmailUserName = "j10mehdig@gmail.com";
    private String gmailPassword = "golestan42";
    //=====================================================

    public void postMail(String recipient, String subject,
                         String message, String from)
                        throws MessagingException {
        boolean debug = false;

        //Set the host smtp address
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                             "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.quitwait", "false");

        Session session = Session.getDefaultInstance(props, this);

        session.setDebug(debug);

        // create a message
        Message msg = new MimeMessage(session);

        // set the from and to address
        InternetAddress addressFrom = new InternetAddress(from);
        msg.setFrom(addressFrom);

        InternetAddress addressTo = new InternetAddress(recipient);
//        for (int i = 0; i < recipients.length; i++) {
//            addressTo[i] = new InternetAddress(recipients[i]);
//        }
        msg.setRecipient(Message.RecipientType.TO, addressTo);

        // Setting the Subject and Content Type
        msg.setSubject(subject);
        msg.setContent(message, "text/html");
        Transport.send(msg);
    }

    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(gmailUserName, gmailPassword);
    }

    public static void main(String[] args) {
        try {

            String message = "Your HTML Message goes here";
            String subject = "This is the subject";
            String fromAddress = "j10mehdig@gmail.com";

            GMailClient mailClient = new GMailClient();
            BufferedReader in = new BufferedReader(
                               new FileReader("/Users/iraj/Desktop/recipients.txt"));
            mailClient.postMail("iraj@zas.se", subject,
            		"Hi "  + ", n" + message, fromAddress);
            in.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}