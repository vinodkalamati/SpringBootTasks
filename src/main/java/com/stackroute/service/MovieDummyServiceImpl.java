package com.stackroute.service;

import com.stackroute.domain.Movie;
import com.stackroute.exceptions.MovieAlreadyExistsException;
import com.stackroute.exceptions.MovieNotFoundException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("movieDummyService")
@Profile("temp")

public class MovieDummyServiceImpl implements MovieService, ApplicationListener<ContextRefreshedEvent>, CommandLineRunner {

    @Override
    public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException {
        return null;
    }

    @Override
    public List<Movie> getAllMovies() {
        return null;
    }

    @Override
    public boolean deleteMovie(int id) throws MovieNotFoundException {
        return false;
    }

    @Override
    public boolean updateMovie(Movie movie) throws MovieNotFoundException {
        return false;
    }

    @Override
    public Movie getMovieByName(String movieTitle) throws MovieNotFoundException {
        return null;
    }

    @Override
    public void run(String... args) throws Exception {

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

    }
}
