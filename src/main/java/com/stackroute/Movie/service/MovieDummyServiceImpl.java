package com.stackroute.Movie.service;

import com.stackroute.Movie.domain.Movie;
import com.stackroute.Movie.exception.MovieAlreadyExistException;
import com.stackroute.Movie.exception.MovieNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MovieDummyServiceImpl implements MovieService{
    @Override
    public Movie saveMovie(Movie movie) throws MovieAlreadyExistException {
        return null;
    }

    @Override
    public Movie showMovieDetails(int movieId) {
        return null;
    }

    @Override
    public List<Movie> showMovieList() {
        return null;
    }

    @Override
    public Movie showMovieCount() {
        return null;
    }

    @Override
    public Movie updateMovie(Movie movie) {
        return null;
    }

    @Override
    public Movie deleteMovie(int movieId) {
        return null;
    }

    @Override
    public List<Movie> trackByName(String title) throws MovieNotFoundException {
        return null;
    }
}
