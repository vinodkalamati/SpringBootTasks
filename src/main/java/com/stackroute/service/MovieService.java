package com.stackroute.service;

import com.stackroute.domain.Movie;

import java.util.List;

public interface MovieService {

    public Movie saveMovie(Movie movie);
    public List<Movie> getAllMovies();
    public Movie getMovieById(int id);
    public boolean deleteMovie(int id);
}
