package com.RottenTomatoesXML;

import java.util.ArrayList;

/**
 * Created by jugs on 9/29/16.
 */
public class RottenTomatoesObject
{
    private long id;
    private String title;
    private String date;
    private String duration;
    private String storyline;
    private String rating;
    private String[] genre;
    private String[] directors;
    private String[] actors;
    private ArrayList<String> reviews;


    public RottenTomatoesObject(long id,String title, String date, String duration, String storyline, String[] genre, String[] directors, String[] actors,String rate,ArrayList review)
    {
        this.id = id;
        this.title = title;
        this.date = date;
        this.duration = duration;
        this.storyline = storyline;
        this.genre = genre;
        this.directors = directors;
        this.actors = actors;
        this.rating = rate;
        this.reviews = review;
    }

    public long getId() {
        return id;
    }

    public ArrayList<String> getReviews() {
        return reviews;
    }

    public String getRating() {
        return rating;
    }

    public String getTitle()
    {
        return title;
    }

    public String getDate()
    {
        return date;
    }

    public String getDuration()
    {
        return duration;
    }

    public String getStoryline()
    {
        return storyline;
    }

    public String[] getGenre()
    {
        return genre;
    }

    public String[] getDirectors()
    {
        return directors;
    }

    public String[] getActors()
    {
        return actors;
    }
}
