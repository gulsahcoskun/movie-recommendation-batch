package com.gulsah.moviedb.movierecommendationbatch.service;

import com.gulsah.moviedb.movierecommendationbatch.model.Mail;
import org.springframework.mail.SimpleMailMessage;

import java.util.Locale;

/**
 * Created by GulsahCoskun on 3.02.2018.
 */
public interface EmailService {

    void sendSimpleMessage(final Mail mail);

    void sendMessageWithAttachments(final Mail mail);
}
