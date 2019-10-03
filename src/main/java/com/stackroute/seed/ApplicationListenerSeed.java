package com.stackroute.seed;

import com.stackroute.domain.Movie;
import com.stackroute.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationListenerSeed implements ApplicationListener<ContextRefreshedEvent> {


        private MovieRepository movieRepository;

        @Autowired
        public ApplicationListenerSeed(MovieRepository movieRepository) {
            this.movieRepository=movieRepository;
        }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Movie movie=new Movie(1,"KingIsland","QQQQWWWEEERRRTTY","English");
        Movie movie1=new Movie(4,"Saaho","Blockbuster Movie Prabhas","Telugu");

        movieRepository.save(movie);
        movieRepository.save(movie1);
    }
}

