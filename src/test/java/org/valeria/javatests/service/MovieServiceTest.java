package org.valeria.javatests.service;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.valeria.javatests.data.MovieRepository;
import org.valeria.javatests.model.Gender;
import org.valeria.javatests.model.Movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {
    @Test
    void returnMoviesByGender() {
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);
        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1,"Dark Knight",144 , Gender.COMEDIA ),
                        new Movie(2, "Memento",60, Gender.FANTASIA),
                        new Movie(3, "There's Something About Mary", 180, Gender.COMEDIA)
        ));
        MovieService movieService = new MovieService(movieRepository);
        Collection<Movie> movies = movieService.findMoviesByGender(Gender.COMEDIA);
        List<Integer> movieIds = movies.stream().map(movie -> movie.getId()).collect(Collectors.toList());
        assertThat(movieIds, CoreMatchers.is(Arrays.asList(1,3)));
    }
}