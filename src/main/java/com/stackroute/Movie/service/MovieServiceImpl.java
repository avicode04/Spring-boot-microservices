package com.stackroute.Movie.service;

import com.stackroute.Movie.domain.Movie;
import com.stackroute.Movie.exception.MovieAlreadyExistException;
import com.stackroute.Movie.exception.MovieNotFoundException;
import com.stackroute.Movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class MovieServiceImpl implements MovieService {

    MovieRepository movieRepo;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepo = movieRepository;
    }

    @Override
    public Movie saveMovie(Movie movie) throws MovieAlreadyExistException {
        if (movieRepo.existsById(movie.getMovieId())) {
            throw new MovieAlreadyExistException("Movie already exists exception");
        }
        Movie newMovie = movieRepo.save(movie);
        System.out.println(movie.getMovieTitle());
        if (newMovie == null) {
            throw new MovieAlreadyExistException("Movie already exists null..");
        }
        return newMovie;
    }

    @Override
    public Movie showMovieDetails(int movieId) {
        Movie findMovie = movieRepo.findById(movieId).orElse(null);
        return findMovie;
    }

    @Override
    public List<Movie> showMovieList() {
        List<Movie> movieList = movieRepo.findAll();
        for (Movie m : movieList) {
            System.out.println(m.getMovieTitle());
        }
        return movieList;
    }

    @Override
    public Movie showMovieCount() {
        int count = showMovieList().size();
        System.out.println("Total Movies=" + count);
        Movie m = null;
        return m;
    }

    @Override
    public Movie updateMovie(Movie movie) {
        return null;
    }

//    @Override
//    public Movie updateMovie(Movie movie) {
//        Movie foundMovie = movieRepo.getOne(movie.getMovieId());
//        System.out.println("Movie:" + foundMovie.getMovieTitle() + " changed to " + movie.getMovieTitle());
//        foundMovie.setMovieDesc(movie.getMovieDesc());
//        foundMovie.setMovieTitle(movie.getMovieTitle());
//        foundMovie.setVoteAverage(movie.getVoteAverage());
//        foundMovie.setVoteCount(movie.getVoteCount());
//        return movieRepo.save(foundMovie);
//    }

    @Override
    public Movie deleteMovie(int movieId) {
        Movie m = null;
        if (movieRepo.findById(movieId).orElse(null) == null) {
            return m;
        }
        m = movieRepo.findById(movieId).orElse(null);
        System.out.println("Delete movie:" + m.getMovieTitle());
        movieRepo.delete(m);
        return m;
    }

    @Override
    public List<Movie> trackByName(String title) throws MovieNotFoundException {
        return null;
    }

//    @Override
//    public List<Movie> trackByName(String title) throws MovieNotFoundException {
//        List<Movie> m = null;
//        if(movieRepo.trackByName(title).isEmpty()){
//            throw new MovieNotFoundException("Movie not found..");
//
//        }
//        m = movieRepo.trackByName(title);
//        return m;
//    }
}
