package se.datalayer.guards.main;

import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.util.Assert;

public class EmailUtil {
    /* Email From param */
    public static final String FROM = "from";

    /* Email To param */
    public static final String TO = "to";

    /* Email Subject param */
    public static final String SUBJECT = "subject";

    /* Email CC param */
    public static final String CC_LIST = "ccList";

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private VelocityEngine velocityEngine;

    public void send(final String templateName, final Map<String, Object> model) {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            @SuppressWarnings("unchecked")
            public void prepare(MimeMessage mimeMessage) throws Exception {
                String from = (String) model.get(FROM);
                String to = (String) model.get(TO);
                String subject = (String) model.get(SUBJECT);
                Assert.notNull(from);
                Assert.notNull(to);
                Assert.notNull(subject);
                List<String> ccList = (List<String>) model.get(CC_LIST);
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                message.setFrom(from);
                message.setTo(to);
                message.setSubject(subject);
                if (ccList != null) {
                    for (String cc : ccList) {
                        message.addCc(cc);
                    }
                }

                String text = VelocityEngineUtils.mergeTemplateIntoString(
                        velocityEngine, templateName, model);
                message.setText(text, true);
            }
        };

        mailSender.send(preparator);
    }
}