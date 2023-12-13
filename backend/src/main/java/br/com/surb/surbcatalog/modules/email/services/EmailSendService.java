package br.com.surb.surbcatalog.modules.email.services;


import br.com.surb.surbcatalog.modules.email.entities.Attachment;
import br.com.surb.surbcatalog.modules.email.entities.EmailInfo;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppMessagingException;
import br.com.surb.surbcatalog.shared.AppUtils.AppStringUtils;
import jakarta.activation.DataHandler;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import jakarta.mail.util.ByteArrayDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.Context;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class EmailSendService {
    private static final Logger logger = LoggerFactory.getLogger(EmailSendService.class);
    private static final String TEXT_HTML_CHARSET_UTF_8 = "text/html;chaset=UTF-8";

    private final JavaMailSender javaMailSender;
    private final ITemplateEngine templateEngine;

    public EmailSendService(JavaMailSender javaMailSender, ITemplateEngine templateEngine) {
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
    }

    @Async
    public void send(EmailInfo emailInfo) {
        logger.info("Sending e-mail whth subject '{}' to '{}'", emailInfo.getSubject(), emailInfo.getTo());

        MimeMessage mineMessage = javaMailSender.createMimeMessage();
        MimeMultipart multipart = new MimeMultipart();

        addBasicDetails(emailInfo, mineMessage);
        addHtmlBody(emailInfo.getTemplate(), emailInfo.getTemplateData(), multipart);
        addAttachments(emailInfo.getAttachments(), multipart);

        setContent(mineMessage, multipart);
        javaMailSender.send(mineMessage);
    }

    private void addBasicDetails(EmailInfo emailInfo, MimeMessage mineMessage) {
        try {
            mineMessage.setFrom(emailInfo.getFrom());
            mineMessage.setSubject(emailInfo.getSubject());
            mineMessage.addRecipients(Message.RecipientType.TO, AppStringUtils.join(emailInfo.getTo()));

            if (Objects.isNull(emailInfo.getCc())) {
                mineMessage.addRecipients(Message.RecipientType.CC, AppStringUtils.join(emailInfo.getCc()));
            }

            if (Objects.isNull(emailInfo.getBcc())) {
                mineMessage.addRecipients(Message.RecipientType.BCC, AppStringUtils.join(emailInfo.getBcc()));
            }
        } catch (MessagingException e) {
            throwEmailSendingException(e, "Error adding data to MINE Message");
        }
    }

    private void addHtmlBody(String template, Map<String, Object> templateData, MimeMultipart multipart) {
        MimeBodyPart messageHtmlPart = new MimeBodyPart();
        Context context = new Context();

        if (Objects.nonNull(templateData)) {
            context.setVariables(templateData);
        }

        try {
            messageHtmlPart.setContent(templateEngine.process(template, context), TEXT_HTML_CHARSET_UTF_8);
            multipart.addBodyPart(messageHtmlPart);
        } catch (Exception e) {
            throwEmailSendingException(e, "Error adding HTML content to MINE Message");
        }
    }

    private void addAttachments(List<Attachment> attachments, MimeMultipart multipart) {
        if (Objects.nonNull(attachments)) {
            attachments.forEach(a -> {
                try {
                    MimeBodyPart mimeBodyPart = new MimeBodyPart();
                    mimeBodyPart.setDataHandler(new DataHandler(new ByteArrayDataSource(a.getInputStream(), a.getContentType())));
                    mimeBodyPart.setFileName(a.getFileName());
                    multipart.addBodyPart(mimeBodyPart);
                } catch (MessagingException | IOException e) {
                    throwEmailSendingException(e, "Error adding attachments to MINE Message");
                }
            });
        }
    }

    private void setContent(MimeMessage mineMessage, MimeMultipart multipart) {
        try {
            mineMessage.setContent(multipart);
        } catch (MessagingException e) {
            throwEmailSendingException(e, "Error setting content to MINE Message");
        }
    }

    private void throwEmailSendingException(Exception exception, String errorMessage) {
        String fullErrorrMessage = String.format("%s %s", exception.getMessage(), errorMessage);
        logger.error(fullErrorrMessage);
        throw new AppMessagingException(fullErrorrMessage);
    }
}
