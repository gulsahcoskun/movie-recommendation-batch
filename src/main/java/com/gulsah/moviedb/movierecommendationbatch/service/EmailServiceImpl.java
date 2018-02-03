package com.gulsah.moviedb.movierecommendationbatch.service;


import com.gulsah.moviedb.movierecommendationbatch.model.Mail;
import freemarker.core.ParseException;
import freemarker.template.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Created by GulsahCoskun on 3.02.2018.
 */
@Component
public class EmailServiceImpl implements EmailService {


    private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Autowired
    public JavaMailSender mailSender;

    @Autowired
    public Configuration freeMarkerconfig;

    @Override
    public void sendSimpleMessage(final Mail mail) {
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(mail.getTo());
            message.setSubject(mail.getSubject());
            message.setText(mail.getContent());

            mailSender.send(message);
        } catch (MailException e){
            logger.error(e.toString());
        }
    }


    @Override
    public void sendMessageWithAttachments(final Mail mail) {
        try{
            final MimeMessage message = mailSender.createMimeMessage();
            final MimeMessageHelper helper = new MimeMessageHelper(message,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());

            /*FileSystemResource file = new FileSystemResource(new File(mail.getPathToAttachment()));
            helper.addAttachment("Invoice",file);*/

            //helper.addAttachment("icon.png", new ClassPathResource("icon.png"));


            Template template = freeMarkerconfig.getTemplate("email-template.ftl");
            String htmlMessage = FreeMarkerTemplateUtils.processTemplateIntoString(template,mail.getModel());

            helper.setTo(mail.getTo());
            helper.setSubject(mail.getSubject());
            helper.setText(htmlMessage,true);

            mailSender.send(message);

        } catch (MessagingException e){
            logger.error(e.toString());
        } catch (MalformedTemplateNameException e) {
            logger.error(e.toString());
        } catch (ParseException e) {
            logger.error(e.toString());
        } catch (TemplateNotFoundException e) {
            logger.error(e.toString());
        } catch (IOException e) {
            logger.error(e.toString());
        } catch (TemplateException e) {
            logger.error(e.toString());
        }
    }
}
