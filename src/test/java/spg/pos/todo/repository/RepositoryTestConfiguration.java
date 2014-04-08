package spg.pos.todo.repository;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import spg.pos.todo.model.DomainConfiguration;
import spg.pos.todo.repository.RepositoryConfiguration;

/**
 * Configuration for testing.
 * 
 * @author Dominik
 */
@Configuration
@Import({DomainConfiguration.class, RepositoryConfiguration.class})
public class RepositoryTestConfiguration {

	@Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
    }
}
