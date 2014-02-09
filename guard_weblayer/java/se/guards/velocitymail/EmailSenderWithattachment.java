package se.guards.velocitymail;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

//@Component("emailSenderWithattachment")
public class EmailSenderWithattachment {
 
    private JavaMailSender mailSender;
 
    private VelocityEngine velocityEngine= new VelocityEngine();
 
 
    public void sendEmail(final String toEmailAddresses, final String fromEmailAddress,
                          final String subject) {
 
        sendEmail(toEmailAddresses, fromEmailAddress, subject, null, null);
 
    }
 
    public void sendEmailWithAttachment(final String toEmailAddresses, final String fromEmailAddress,
                                        final String subject, final String attachmentPath,
                                        final String attachmentName) {
 
        sendEmail(toEmailAddresses, fromEmailAddress, subject, attachmentPath, attachmentName);
 
    }
 
    private void sendEmail(final String toEmailAddresses, final String fromEmailAddress,
                           final String subject, final String attachmentPath,
                           final String attachmentName) {
 
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
 
            public void prepare(MimeMessage mimeMessage) throws Exception {
 
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);
                message.setTo(toEmailAddresses);
                message.setFrom(new InternetAddress(fromEmailAddress));
                message.setSubject(subject);
 
                String body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "velocity/lost-password.vm", "UTF-8", null);
                message.setText(body, true);
 
                    FileSystemResource file = new FileSystemResource(attachmentPath);
                    message.addAttachment(attachmentName, file);
            }
        };
        this.mailSender.send(preparator);
    }
}