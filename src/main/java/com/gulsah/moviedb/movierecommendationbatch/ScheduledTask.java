package com.gulsah.moviedb.movierecommendationbatch;

import com.gulsah.moviedb.movierecommendationbatch.service.EmailService;
import com.gulsah.moviedb.movierecommendationbatch.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by GulsahCoskun on 3.02.2018.
 */
@Component
public class ScheduledTask {

    @Autowired
    private EmailService emailService;

    @Autowired
    private MovieService movieService;

    @Scheduled(fixedRate = 500000)
    public void sendMovieMails(){
        movieService = new MovieService(new RestTemplateBuilder());
        emailService.sendSimpleMessage("gulsahcoskunn@gmail.com","Haftalık Film Önerileri",
               movieService.getPopularMovies()[1].toString() );
    }

}

