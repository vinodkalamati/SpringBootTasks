package com.stackroute.controller;

import com.stackroute.domain.Movie;
import com.stackroute.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
public class MovieController {

    MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    //create Movie
    @PostMapping("movie")
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie){
            ResponseEntity responseEntity;
            movieService.saveMovie(movie);
            responseEntity=new ResponseEntity("Successfully Created", HttpStatus.CREATED);
            return responseEntity;
    }

    //Retrieve Movie
    @GetMapping("movie")
    public ResponseEntity<?> getAllMovies(){
        List<Movie> retrievedMovie=movieService.getAllMovies();
        ResponseEntity responseEntity;
        movieService.getAllMovies();
        responseEntity=new ResponseEntity<List<Movie>>(retrievedMovie,HttpStatus.OK);
        return responseEntity;
    }

    //Update Movie
    @PutMapping("movie")
    public ResponseEntity<?> updateMovie(@RequestBody Movie movie){
        ResponseEntity responseEntity;
        movieService.updateMovie(movie);
        responseEntity=new ResponseEntity<Movie>(movie, HttpStatus.ACCEPTED);
        return responseEntity;
    }

    //DeleteMovie
    @DeleteMapping("movie")
    public ResponseEntity<?> getDeleteById(@RequestBody int id){
        ResponseEntity responseEntity;
        movieService.deleteMovie(id);
        responseEntity=new ResponseEntity<String>("Successfully Deleted",HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("movie/search")
    public ResponseEntity<?> getMovieByName(@RequestBody String movieTitle){
        ResponseEntity responseEntity;
        Movie movie=movieService.getMovieByName(movieTitle);
        responseEntity=new ResponseEntity<Movie>(movie, HttpStatus.FOUND);
        return responseEntity;


    }



}
