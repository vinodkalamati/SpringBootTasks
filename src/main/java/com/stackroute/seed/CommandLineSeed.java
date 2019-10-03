package com.stackroute.seed;

import com.stackroute.domain.Movie;
import com.stackroute.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineSeed implements CommandLineRunner {

    private MovieRepository movieRepository;


        @Autowired
        public CommandLineSeed(MovieRepository movieRepository) {
            this.movieRepository=movieRepository;
        }

        @Override
        public void run(String... args) throws Exception {
            Movie movie=new Movie(2,"Queen","Overview Comming Soon","Hindi");
            Movie movie1=new Movie(3,"Syeraa","Blockbuster Movie Cheeranjeevi","Telugu");
            movieRepository.save(movie);
            movieRepository.save(movie1);
        }
}
