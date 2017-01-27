package com.gostgroup.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author root
 */
@Configuration
@EnableJpaRepositories(basePackages = "repository")
public class DatabaseConfig {

  @Autowired
  private Environment env;

  @Autowired
  private DataSource dataSource;


  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    LocalContainerEntityManagerFactoryBean entityManagerFactory =
        new LocalContainerEntityManagerFactoryBean();

    entityManagerFactory.setDataSource(dataSource);

    // Classpath scanning of @Component, @Service, etc annotated class
    entityManagerFactory.setPackagesToScan(
        env.getProperty("entitymanager.packagesToScan"));

    // Vendor adapter
    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    entityManagerFactory.setJpaVendorAdapter(vendorAdapter);

    // Hibernate properties
    Properties additionalProperties = new Properties();
    additionalProperties.put(
        "hibernate.dialect",
        env.getProperty("hibernate.dialect"));
    additionalProperties.put(
        "hibernate.show_sql",
        env.getProperty("hibernate.show_sql"));
    additionalProperties.put(
        "hibernate.hbm2ddl.auto",
        env.getProperty("hibernate.hbm2ddl.auto"));
    entityManagerFactory.setJpaProperties(additionalProperties);

    return entityManagerFactory;
  }

}
