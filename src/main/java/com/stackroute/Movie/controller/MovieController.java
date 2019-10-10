package com.stackroute.Movie.controller;


import com.stackroute.Movie.domain.Movie;
import com.stackroute.Movie.exception.MovieAlreadyExistException;
import com.stackroute.Movie.exception.MovieNotFoundException;
import com.stackroute.Movie.service.MovieService;
import com.stackroute.Movie.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class MovieController {
    MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    public MovieController() {

    }

    @GetMapping("movie")
    public ResponseEntity<?> getMovie(@RequestParam("movieTitle") String title) throws MovieNotFoundException {
        ResponseEntity responseEntity;
        List<Movie> m = null;
        m = movieService.trackByName(title);
        responseEntity = new ResponseEntity<List<Movie>>(m, HttpStatus.CREATED);
        return responseEntity;
    }

    @PostMapping("movie")
    public ResponseEntity saveMovie(@RequestBody Movie movie) throws MovieAlreadyExistException {
        ResponseEntity responseEntity;
         Movie m = movieService.saveMovie(movie);
        responseEntity = new ResponseEntity<>(m, HttpStatus.CREATED);
        return responseEntity;
    }
    @PutMapping("movie")
    public ResponseEntity updateMovie(@RequestBody Movie movie) {
        ResponseEntity responseEntity;
        Movie m = null;
        try {
            m = movieService.updateMovie(movie);
            responseEntity = new ResponseEntity<Movie>(m, HttpStatus.CREATED);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<Movie>(m, HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @DeleteMapping("movie")
    public ResponseEntity deleteMovie(@RequestBody Movie movie) {
        ResponseEntity responseEntity;
        Movie m = null;
        try {
            m = movieService.deleteMovie(movie.getMovieId());
            responseEntity = new ResponseEntity<Movie>(m, HttpStatus.CREATED);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<Movie>(m, HttpStatus.CONFLICT);
        }
        return responseEntity;
    }


    @RequestMapping(value = "/echoUserName/{name}")
    public String echoUserName(@PathVariable(name = "name") String name)
    {
        return "hello  <strong style=\"color: red;\">" + name + " </strong> Responsed on : " + new Date();
    }

    @RequestMapping(value = "/getUserDetails/{name}")
    public User getUserDetails(@PathVariable(name = "name") String name)
    {
        return new User(name, "Pune", "MCA");
    }

    public static void main(String[] args)
    {
        SpringApplication.run(MovieController.class, args);
    }



}
