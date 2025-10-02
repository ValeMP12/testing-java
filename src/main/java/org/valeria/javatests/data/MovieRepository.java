package org.valeria.javatests.data;

import org.valeria.javatests.model.Movie;

import java.util.Collection;

public interface MovieRepository {
    Movie findById(Integer id);
    Collection<Movie> findAll();
    Movie saveOrUpdate(Movie movie);
}
