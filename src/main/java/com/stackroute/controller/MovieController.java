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

    @PostMapping("movie")
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie){
        ResponseEntity responseEntity;
        try {
            movieService.saveMovie(movie);
            responseEntity=new ResponseEntity("Successfully Created", HttpStatus.CREATED);
        }
        catch (Exception ex){
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("movie")
    public ResponseEntity<?> getAllMovies(){
        List<Movie> retrievedMovie=movieService.getAllMovies();
        ResponseEntity responseEntity;
        try{
            movieService.getAllMovies();
            responseEntity=new ResponseEntity<List<Movie>>(retrievedMovie,HttpStatus.OK);
        }
        catch (Exception ex){
            responseEntity=new ResponseEntity<String>("Movie Not Found",HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("find")
    public ResponseEntity<?> getMovieById(){
        ResponseEntity responseEntity;
        Movie movie=movieService.getMovieById(2);
        try{
            responseEntity=new ResponseEntity<Movie>(movie,HttpStatus.FOUND);
        }
        catch (Exception ex){
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("delete")
    public ResponseEntity<?> getDeleteById(){
        ResponseEntity responseEntity;

        try{
            movieService.deleteMovie(2);
            responseEntity=new ResponseEntity<String>("Successfully Deleted",HttpStatus.OK);
        }
        catch (Exception ex){
            responseEntity=new ResponseEntity<String>("Movie Not found",HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

}
