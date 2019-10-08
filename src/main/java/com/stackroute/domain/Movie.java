package com.stackroute.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@ApiModel

public class Movie {
    @Id
    @ApiModelProperty(notes = "Id of the movie primary key")
    int id;
    @ApiModelProperty(notes = "Title of the movie")
    String movieTitle;
    @ApiModelProperty(notes = "overview of the movie")
    String overview;
    @ApiModelProperty(notes = "Movie language")
    String language;

    public Movie() {
    }

    public Movie(int id, String movieTitle, String overview, String language) {
        this.id = id;
        this.movieTitle = movieTitle;
        this.overview = overview;
        this.language = language;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", movieTitle='" + movieTitle + '\'' +
                ", overview='" + overview + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
