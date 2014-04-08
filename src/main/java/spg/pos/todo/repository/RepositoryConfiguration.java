package spg.pos.todo.repository;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import spg.pos.todo.model.DomainPackage;

/**
 * 
 * @author Dominik
 *
 */

@Configuration
@EnableJpaRepositories
@ComponentScan(basePackageClasses = RepositoryPackage.class)
public class RepositoryConfiguration
{
  @Bean
  public JpaVendorAdapter jpaVendorAdapter() {
      HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
      hibernateJpaVendorAdapter.setShowSql(true);
      hibernateJpaVendorAdapter.setGenerateDdl(true);
      hibernateJpaVendorAdapter.setDatabase(Database.H2);
      return hibernateJpaVendorAdapter;
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,
          JpaVendorAdapter jpaVendorAdapter) {
      LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
      lef.setDataSource(dataSource);
      lef.setJpaVendorAdapter(jpaVendorAdapter);
      lef.setPackagesToScan(DomainPackage.class.getPackage().getName());
      return lef;
  }
}
