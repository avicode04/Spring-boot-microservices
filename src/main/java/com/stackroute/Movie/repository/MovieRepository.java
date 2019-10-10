package com.stackroute.Movie.repository;

import com.stackroute.Movie.domain.Movie;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<Movie, Integer> {

//    @Query("select m from Movie m where LOWER(m.movieTitle)=LOWER(:title)")
//    public List<Movie> trackByName(@Param("title") String title);




}
