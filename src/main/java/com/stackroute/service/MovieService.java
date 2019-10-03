package com.stackroute.service;

import com.stackroute.domain.Movie;
import java.util.List;

public interface MovieService {

    public Movie saveMovie(Movie movie);
    public List<Movie> getAllMovies();
    public boolean deleteMovie(int id);
    boolean updateMovie(Movie movie);
}
