package com.stackroute.Movie.service;


import com.stackroute.Movie.domain.Movie;
import com.stackroute.Movie.exception.MovieAlreadyExistException;
import com.stackroute.Movie.repository.MovieRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class MovieServiceTest {

    Movie movie;

    @Mock
    MovieRepository movieRepository;

    @InjectMocks
    MovieServiceImpl movieService;
    List<Movie> movieList=null;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        movie=new Movie();
        movie.setMovieId(1);
        movie.setMovieTitle("Joker");
        movie.setMovieDesc("Movie on clowns");
        movie.setVoteCount(1000);
        movie.setVoteAverage(9.7);
        movieList=new ArrayList<>();
        movieList.add(movie);

    }


    @After
    public void tearDown(){
        movieList=null;
    }


    @Test
    public void saveMovieTestSuccess() throws MovieAlreadyExistException {

        when(movieRepository.save((Movie)any())).thenReturn(movie);
        Movie savedMovie = movieService.saveMovie(movie);
        Assert.assertEquals(movie,savedMovie);

        //verify here verifies that userRepository save method is only called once
        verify(movieRepository,times(1)).save(movie);

    }

    @Test(expected = MovieAlreadyExistException.class)
    public void saveUserTestFailure() throws MovieAlreadyExistException {
        when(movieRepository.save((Movie)any())).thenReturn(null);
        Movie savedMovie = movieService.saveMovie(movie);
        System.out.println("savedUser" + savedMovie);
        //Assert.assertEquals(user,savedUser);

       /*doThrow(new UserAlreadyExistException()).when(userRepository).findById(eq(101));
       userService.saveUser(user);*/
    }

    @Test
    public void getAllUser(){

        movieRepository.save(movie);
        //stubbing the mock to return specific data
        when(movieRepository.findAll()).thenReturn(movieList);
        List<Movie> movielist = movieService.showMovieList();
        Assert.assertEquals(movieList,movielist);
    }

}
