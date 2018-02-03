package com.gulsah.moviedb.movierecommendationbatch.service;

import com.gulsah.moviedb.movierecommendationbatch.model.Movie;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by GulsahCoskun on 3.02.2018.
 */
@Service
public class MovieService {

    private final RestTemplate restTemplate;

    public MovieService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate= restTemplateBuilder.build();
    }

    public Movie[] getPopularMovies(){
        return this.restTemplate.getForEntity("http://localhost:8010/movies/popular-movies/",Movie[].class).getBody();
    }

    public Movie[] getMoviesAtCinemas(){
        return this.restTemplate.getForEntity("http://localhost:8010/movies/current-movies/",Movie[].class).getBody();
    }

    public Movie[] getHighestRatedMovies(){
        return this.restTemplate.getForEntity("http://localhost:8010/movies/highest-rated-movies/",Movie[].class).getBody();
    }

    public Movie[] getMoviesToCome(){
        return this.restTemplate.getForEntity("http://localhost:8010/movies/movies-to-come/",Movie[].class).getBody();
    }

}
