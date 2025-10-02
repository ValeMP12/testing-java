package org.valeria.javatests.service;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.valeria.javatests.data.MovieRepository;
import org.valeria.javatests.model.Gender;
import org.valeria.javatests.model.Movie;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import static org.hamcrest.MatcherAssert.assertThat;

class MovieServiceTest {
    private MovieService movieService;
    @BeforeEach
    void setUp() {
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);
        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1,"Dark Knight",144 , Gender.COMEDIA ),
                        new Movie(2, "Memento",60, Gender.FANTASIA),
                        new Movie(3, "There's Something About Mary", 180, Gender.COMEDIA)
                ));
        movieService = new MovieService(movieRepository);
    }

    @Test
    void returnMoviesByGender() {
        Collection<Movie> movies = movieService.findMoviesByGender(Gender.COMEDIA);
        List<Integer> movieIds = getMoviesIds(movies);
        assertThat(movieIds, CoreMatchers.is(Arrays.asList(1,3)));
    }
    private static List<Integer> getMoviesIds(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }

    @Test
    void returnMovieByDuration() {
        Collection<Movie> movies = movieService.findMoviesByDuration(150);
        List<Integer> movieIds = getMoviesIds(movies);
        assertThat(movieIds, CoreMatchers.is(Arrays.asList(1,2)));
    }
}