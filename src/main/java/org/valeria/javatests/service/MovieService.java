package org.valeria.javatests.service;

import org.valeria.javatests.data.MovieRepository;
import org.valeria.javatests.model.Gender;
import org.valeria.javatests.model.Movie;

import java.util.Collection;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MovieService {
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMoviesByGender(Gender gender) {

        return movieRepository.findAll().stream().toList().stream().filter(movie -> movie.getGender() == gender).collect(Collectors.toList());
    }
}
