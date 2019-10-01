package com.stackroute.service;

import com.stackroute.domain.Movie;
import javassist.NotFoundException;

import java.util.List;

public interface MovieService {

    public Movie saveMovie(Movie movie);
    public List<Movie> getAllMovies();
    public Movie getMovieById(int id) throws NotFoundException;
    public boolean deleteMovie(int id);
    boolean updateMovie(Movie movie) throws NotFoundException;
}
