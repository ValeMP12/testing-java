package org.valeria.javatests.data;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.valeria.javatests.model.Gender;
import org.valeria.javatests.model.Movie;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class MovieRepositoryJdbcTest {
    @Test
    void loadAllMovies() throws SQLException {
        DataSource dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");
        ScriptUtils.executeSqlScript(dataSource.getConnection(),new ClassPathResource("sql-scripts/test-data.sql"));
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        MovieRepositoryJdbc movieRepository =  new MovieRepositoryJdbc(jdbcTemplate);
        Collection<Movie> movies = movieRepository.findAll();
        assertThat(movies, is(Arrays.asList(
                new Movie(1, "Inception", 148, Gender.SCI_FI),
                new Movie(2, "The Dark Knight", 152, Gender.ACCION)
        )));
    }
}