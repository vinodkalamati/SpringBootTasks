package com.stackroute.controller;

import com.stackroute.domain.Movie;
import com.stackroute.exceptions.MovieAlreadyExistsException;
import com.stackroute.exceptions.MovieNotFoundException;
import com.stackroute.service.MovieService;
import io.swagger.annotations.Api;
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
        try {
            movieService.saveMovie(movie);
            responseEntity=new ResponseEntity("Successfully Created", HttpStatus.CREATED);
        }
        catch (MovieAlreadyExistsException ex){
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }


    //Retrieve Movie

    @GetMapping("movie")
    public ResponseEntity<?> getAllMovies(){
        List<Movie> retrievedMovie=movieService.getAllMovies();
        ResponseEntity responseEntity;
        try{
            movieService.getAllMovies();
            responseEntity=new ResponseEntity<List<Movie>>(retrievedMovie,HttpStatus.OK);
        }
        catch (Exception ex){
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    //Update Movie
    @PutMapping("movie")
    public ResponseEntity<?> updateMovie(@RequestBody Movie movie){
        ResponseEntity responseEntity;
        try {
            movieService.updateMovie(movie);
            responseEntity=new ResponseEntity<Movie>(movie, HttpStatus.ACCEPTED);
        }
        catch (MovieNotFoundException ex){
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    //DeleteMovie
    @DeleteMapping("movie")
    public ResponseEntity<?> getDeleteById(@RequestBody int id){
        ResponseEntity responseEntity;

        try{
            movieService.deleteMovie(id);
            responseEntity=new ResponseEntity<String>("Successfully Deleted",HttpStatus.OK);
        }
        catch (MovieNotFoundException ex){
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("movie/search")
    public ResponseEntity<?> getMovieByName(@RequestBody String movieTitle){
        ResponseEntity responseEntity;
        try{
            Movie movie=movieService.getMovieByName(movieTitle);
            responseEntity=new ResponseEntity<Movie>(movie,HttpStatus.FOUND);
        }
        catch (MovieNotFoundException ex){
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;


    }



}
