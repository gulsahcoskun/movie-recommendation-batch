package com.gulsah.moviedb.movierecommendationbatch.model;

import java.util.List;

/**
 * Created by GulsahCoskun on 3.02.2018.
 */
public class MoviesToSend {

    private String type;
    private String title;
    private double vote;
    private double popularity;
    private String overview;
    private String releaseDate;
    private List<Genre> genres;

    public MoviesToSend() {
    }

    public MoviesToSend(String type, String title, double vote, double popularity, String overview, String releaseDate) {
        this.type = type;
        this.title = title;
        this.vote = vote;
        this.popularity = popularity;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.genres = genres;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getVote() {
        return vote;
    }

    public void setVote(double vote) {
        this.vote = vote;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
}
