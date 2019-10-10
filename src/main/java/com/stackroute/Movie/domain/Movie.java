package com.stackroute.Movie.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "Movie")
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    //Lombok used
    @Id
    int movieId;
    int voteCount;
    String movieTitle,movieDesc;
    double voteAverage;
}
