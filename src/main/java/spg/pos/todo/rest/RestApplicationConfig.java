package spg.pos.todo.rest;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import spg.pos.todo.model.DomainConfiguration;
import spg.pos.todo.repository.RepositoryConfiguration;
import spg.pos.todo.repositoryjpa.RepositoryJpaConfiguration;
import spg.pos.todo.service.ServiceConfiguration;
import spg.pos.todo.servicejpa.ServiceJpaConfiguration;

/**
 * Application configuration for rest.
 * 
 * @author Dominik
 */
@Import(value = {DomainConfiguration.class, RepositoryConfiguration.class, ServiceConfiguration.class})
@Configuration
@ComponentScan(basePackageClasses = RestPackage.class)
public class RestApplicationConfig {
	@Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
    }
}