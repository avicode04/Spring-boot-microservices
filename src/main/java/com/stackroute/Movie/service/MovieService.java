package com.stackroute.Movie.service;

import com.stackroute.Movie.domain.Movie;
import com.stackroute.Movie.exception.MovieAlreadyExistException;
import com.stackroute.Movie.exception.MovieNotFoundException;

import java.util.List;

public interface MovieService {

    public Movie saveMovie(Movie movie) throws MovieAlreadyExistException;

    public Movie showMovieDetails(int movieId);

    public List<Movie> showMovieList();

    public Movie showMovieCount();

    public Movie updateMovie(Movie movie);

    public Movie deleteMovie(int movieId);

    public List<Movie> trackByName(String title) throws MovieNotFoundException;

}
