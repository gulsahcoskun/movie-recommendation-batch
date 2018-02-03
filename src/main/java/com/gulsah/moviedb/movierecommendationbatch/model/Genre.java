package com.gulsah.moviedb.movierecommendationbatch.model;

/**
 * Created by GulsahCoskun on 3.02.2018.
 */
public enum Genre {

    ACTION(28),
    ADVANTURE(12),
    ANIMATION(16),
    COMEDY(35),
    CRIME(80),
    DOCUMENTARY(90),
    DRAMA(18),
    FAMILY(10751),
    FANTASY(14),
    HISTORY(36),
    HORROR(27),
    MUSIC(10402),
    MYSTERY(9648),
    ROMANCE(10749),
    SCIENCE_FINCTION(878),
    TV_MOVIE(10770),
    THRILLER(53),
    WAR(10752),
    WESTERN(37);

    private int id;

    Genre(int id){
        this.id = id;
    }

    public String type(int id){
        for(Genre g : Genre.values()){
            if(g.id == id)
                return g.name();
        }
        return "";
    }


}
