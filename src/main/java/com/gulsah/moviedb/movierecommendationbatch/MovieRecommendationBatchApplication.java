package com.gulsah.moviedb.movierecommendationbatch;

import com.gulsah.moviedb.movierecommendationbatch.model.Movie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
public class MovieRecommendationBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieRecommendationBatchApplication.class, args);
	}


}
