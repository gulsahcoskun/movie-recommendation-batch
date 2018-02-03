package com.gulsah.moviedb.movierecommendationbatch.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * Created by GulsahCoskun on 3.02.2018.
 */
@Component
public class EmailServiceImpl implements EmailService {


    private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Autowired
    public JavaMailSender mailSender;

    @Override
    public void sendSimpleMessage(String to, String subject, String text) {
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);

            mailSender.send(message);
        } catch (MailException e){
            logger.error(e.toString());
        }
    }

    @Override
    public void sendMessageWithTemplate(String to, String subject, SimpleMailMessage template, String... templateArgs) {
        String text = String.format(template.getText(), templateArgs);
        sendSimpleMessage(to,subject,text);
    }

    @Override
    public void sendMessageWithAttachments(String to, String subject, String text, String pathToAttachment) {
        try{
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,true);

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);

            FileSystemResource file = new FileSystemResource(new File(pathToAttachment));
            helper.addAttachment("Invoice",file);

            mailSender.send(message);

        } catch (MessagingException e){
            logger.error(e.toString());
        }
    }
}
