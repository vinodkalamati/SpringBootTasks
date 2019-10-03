package com.stackroute.service;

import com.stackroute.domain.Movie;
import com.stackroute.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService  {

    MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    //create Movie
    @Override
    public Movie saveMovie(Movie movie){
        Movie movie1=movieRepository.save(movie);
        return movie1;}

    //Retrieve AllMovies
    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }


    //Delete Movie
    @Override
    public boolean deleteMovie(int id) {
        movieRepository.deleteById(id);
        return true;
    }

    //Update Movie
    @Override
    public boolean updateMovie(Movie movie){
        Movie movie1=movieRepository.findById(movie.getId()).orElse(new Movie());
        movieRepository.save(movie1);
        return true;
    }

    @Override
    public Movie getMovieByName(String movieTitle) {
        Movie movie=movieRepository.getMovieByName(movieTitle);
        return movie;
    }


}
