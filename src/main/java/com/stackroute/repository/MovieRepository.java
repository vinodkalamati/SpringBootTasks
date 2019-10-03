package com.stackroute.repository;

import com.stackroute.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Query(value = "select * from MOVIE where movie_title=:Name",nativeQuery = true)
    Movie getMovieByName(@Param("Name") String movieTitle);
}
