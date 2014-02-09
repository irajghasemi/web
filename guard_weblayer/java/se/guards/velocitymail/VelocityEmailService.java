package se.guards.velocitymail;

import static org.springframework.ui.velocity.VelocityEngineUtils.mergeTemplateIntoString;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;

import se.guard.User;

@Service
public class VelocityEmailService implements VelocityEmailRepository
{
	private static final Logger logger = LoggerFactory.getLogger(VelocityEmailService.class);

	@Autowired(required=false)
	public VelocityEngine velocityEngine;

	@Autowired(required=false)
	public VelocityEngineFactoryBean velocityEngineFactoryBean;

	@Autowired(required=false)
	public JavaMailSender mailSender;

	
	String velocity_WEB_INF_Path="lost-password.vm";

	public void sendLostPasswordEmail(final User user, final String action)
	{
		logger.debug("Sending lost password email to: {}", user.getUsername());
		
		MimeMessagePreparator preparator = new MimeMessagePreparator()
		{
			public void prepare(MimeMessage mimeMessage) throws Exception
			{
				
				velocityEngine.init();
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(user.getEmail());
				message.setFrom("no-reply@gmail.com");
				message.setSubject("Your Password");
				Map<String, Object> model = new HashMap<String, Object>();
				model.put("user", user);
				model.put("url", action);
				String text = mergeTemplateIntoString(velocityEngine, velocity_WEB_INF_Path,"UTF-8", model);
				message.setText(text, true);
			}
		};
		this.mailSender.send(preparator);
	}
	
}
