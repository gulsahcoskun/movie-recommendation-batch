package com.gulsah.moviedb.movierecommendationbatch.service;

import com.gulsah.moviedb.movierecommendationbatch.model.Movie;
import com.gulsah.moviedb.movierecommendationbatch.model.MoviesToSend;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

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

    public List<MoviesToSend> getMoviesToSends() {
        Movie ratedMovie = getHighestRatedMovies()[new Random().nextInt(getHighestRatedMovies().length)+1];
        Movie popularMovie = getPopularMovies()[new Random().nextInt(getPopularMovies().length)+1];
        Movie movieAtCinema = getMoviesAtCinemas()[new Random().nextInt(getMoviesAtCinemas().length)+1];
        Movie movieToCome = getMoviesToCome()[new Random().nextInt(getMoviesToCome().length)+1];

        //todo check for null movies

        return Arrays.asList(
                new MoviesToSend("Vizyondakilerden",movieAtCinema.getTitle(),movieAtCinema.getVote_average(),
                        movieAtCinema.getPopularity(), movieAtCinema.getOverview(),movieAtCinema.getRelease_date()),
                new MoviesToSend("En Yüksek Puanlı",ratedMovie.getTitle(),ratedMovie.getVote_average(),
                        ratedMovie.getPopularity(), ratedMovie.getOverview(),ratedMovie.getRelease_date()),
                new MoviesToSend("En Popüler",popularMovie.getTitle(),popularMovie.getVote_average(),
                        popularMovie.getPopularity(), popularMovie.getOverview(),popularMovie.getRelease_date()),
                new MoviesToSend("Gelecek Sezondan",movieToCome.getTitle(),movieToCome.getVote_average(),
                        movieToCome.getPopularity(), movieToCome.getOverview(),movieToCome.getRelease_date()));
    }

}
