package com.stackroute.service;

import com.stackroute.domain.Movie;
import com.stackroute.exceptions.MovieAlreadyExistsException;
import com.stackroute.exceptions.MovieNotFoundException;
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
    public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException {
        if (movieRepository.existsById(movie.getId()) || movie == null) {
            throw new MovieAlreadyExistsException("Movie already exits unable to save");
        } else {
            Movie movie1 = movieRepository.save(movie);
            return movie1;
        }
    }

    //Retrieve AllMovies
    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }


    //Delete Movie
    @Override
    public boolean deleteMovie(int id) throws MovieNotFoundException {
        if (movieRepository.existsById(id)){
        movieRepository.deleteById(id);}
        else {
            throw new MovieNotFoundException("No movie found with Id "+id);
        }
        return true;
    }

    //Update Movie
    @Override
    public boolean updateMovie(Movie movie) throws MovieNotFoundException {
        Movie movie1=movieRepository.findById(movie.getId()).orElseThrow(()->new MovieNotFoundException("No movie found with Id "+movie.getId()));
        movieRepository.save(movie1);
        return true;
    }

    //movie by name
    @Override
    public Movie getMovieByName(String movieTitle) throws MovieNotFoundException {
        Movie movie=movieRepository.getMovieByName(movieTitle);
        if (movie==null)
        {
            throw new MovieNotFoundException("No movie found with MovieTitle "+movieTitle);
        }
        return movie;
    }


}
