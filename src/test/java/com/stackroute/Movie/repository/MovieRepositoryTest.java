package com.stackroute.Movie.repository;


import com.stackroute.Movie.domain.Movie;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MovieRepositoryTest {

    @Autowired
    MovieRepository movieRepository;
    Movie movie;


    @Before
    public void setUp()
    {
        movie = new Movie();
        movie.setMovieId(1);
        movie.setMovieTitle("Joker");
        movie.setMovieDesc("Movie on clowns");
        movie.setVoteCount(1000);
        movie.setVoteAverage(9.7);
    }

    @After
    public void tearDown(){

        movieRepository.deleteAll();
    }


    @Test
    public void testSaveUser(){
        movieRepository.save(movie);
        Movie fetchUser = movieRepository.findById(movie.getMovieId()).get();
        Assert.assertEquals(1,fetchUser.getMovieId());
    }

    @Test
    public void testSaveUserFailure(){
        movieRepository.save(movie);
        Movie testMovie = new Movie();testMovie.setMovieId(2);testMovie.setMovieTitle("Seven");
        Movie fetchUser = movieRepository.findById(movie.getMovieId()).get();
        Assert.assertNotSame(testMovie,fetchUser);
    }

    @Test
    public void testGetAllUser(){
        Movie m = new Movie();m.setMovieId(1);m.setMovieTitle("Joker");
        Movie m1 = new Movie();m1.setMovieId(2);m1.setMovieTitle("Seven");
        movieRepository.save(m);
        movieRepository.save(m1);

        List<Movie> list = movieRepository.findAll();
        Assert.assertEquals("Joker",list.get(0).getMovieTitle());
    }

}
