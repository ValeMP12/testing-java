package org.valeria.javatests.data;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.valeria.javatests.model.Gender;
import org.valeria.javatests.model.Movie;
import java.util.Collection;

public class MovieRepositoryJdbc implements MovieRepository {
    private JdbcTemplate jdbcTemplate;

    public MovieRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(Integer id) {
        return null;
    }

    @Override
    public Collection<Movie> findAll() {
        return jdbcTemplate.query("SELECT * FROM movies", movieMapper);
    }

    @Override
    public Movie saveOrUpdate(Movie movie) {
        return null;
    }

    private static RowMapper<Movie> movieMapper = (rs, rowNum) -> new Movie(rs.getInt("id"),
            rs.getString("name"),
            rs.getInt("minutes"),
            Gender.valueOf(rs.getString("genre")));
}
