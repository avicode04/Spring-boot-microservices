package com.stackroute.Movie.controllerAdvice;


import com.stackroute.Movie.exception.MovieAlreadyExistException;
import com.stackroute.Movie.exception.MovieNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MovieControllerAdvice {
    @ExceptionHandler(value = MovieNotFoundException.class)
    public ResponseEntity<String> notFoundException(MovieNotFoundException ex){
        return new ResponseEntity<>("Error thrown globally:"+ex.getMessage(),HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value= MovieAlreadyExistException.class)
    public ResponseEntity<String> alreadyExistException(MovieAlreadyExistException e){
        return new ResponseEntity<>("Error thrown globally:" +e.getMessage(),HttpStatus.CONFLICT);
    }
}
