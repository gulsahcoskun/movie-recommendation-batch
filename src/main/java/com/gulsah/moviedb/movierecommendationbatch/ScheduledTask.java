package com.gulsah.moviedb.movierecommendationbatch;

import com.gulsah.moviedb.movierecommendationbatch.model.Mail;
import com.gulsah.moviedb.movierecommendationbatch.model.Movie;
import com.gulsah.moviedb.movierecommendationbatch.model.MoviesToSend;
import com.gulsah.moviedb.movierecommendationbatch.service.EmailService;
import com.gulsah.moviedb.movierecommendationbatch.service.MailList;
import com.gulsah.moviedb.movierecommendationbatch.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by GulsahCoskun on 3.02.2018.
 */
@Component
public class ScheduledTask {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTask.class);

    @Autowired
    private EmailService emailService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private MailList mailList;

    @Scheduled(cron="0 0 6 * * ?")
    public void sendMovieMails(){
        logger.info("Sending Movie Recommendation Email");

        for(Object mailAddress : mailList.getAllValues()){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    Mail mail = new Mail();
                    mail.setTo(mailAddress.toString());
                    mail.setSubject("Haftalık Film Önerileri");

                    Map<String, Object> model = new HashMap<>();
                    model.put( "movies", movieService.getMoviesToSends());
                    mail.setModel(model);

                    emailService.sendMessageWithAttachments(mail);
                }
            });
            thread.start();
        }
    }



}

