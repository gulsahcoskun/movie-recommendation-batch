package com.gulsah.moviedb.movierecommendationbatch.service;

import org.springframework.mail.SimpleMailMessage;

/**
 * Created by GulsahCoskun on 3.02.2018.
 */
public interface EmailService {

    void sendSimpleMessage(String to, String subject, String text);

    void sendMessageWithTemplate(String to, String subject, SimpleMailMessage template, String ...templateArgs);

    void sendMessageWithAttachments(String to, String subject,String text, String pathToAttachment);
}
