package com.stackroute.service;

import com.stackroute.domain.Movie;
import com.stackroute.exceptions.MovieAlreadyExistsException;
import javassist.NotFoundException;

import java.util.List;

public interface MovieService {

    public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException;
    public List<Movie> getAllMovies();
    public Movie getMovieById(int id) throws NotFoundException;
    public boolean deleteMovie(int id);
    boolean updateMovie(Movie movie) throws NotFoundException;
}
