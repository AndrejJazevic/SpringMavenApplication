
package com.maven;

import org.hibernate.jpamodelgen.xml.jaxb.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitManager;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
@ComponentScan("com.maven")
public class AppConfig {
    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl(env.getRequiredProperty("spring.datasource.url"));
        ds.setDriverClassName(env.getRequiredProperty("spring.datasource.driverClassName"));
        ds.setUsername(env.getRequiredProperty("spring.datasource.username"));
        ds.setPassword(env.getRequiredProperty("spring.datasource.password"));
        return ds;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds){
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(ds);
        factory.setJpaProperties(properties());
        factory.setPackagesToScan("com.maven.entity");
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return factory;
    }

    private Properties properties(){
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
        properties.setProperty("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
        properties.setProperty("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
        properties.setProperty("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
        properties.setProperty("hibernate.use_sql_comments", env.getRequiredProperty("hibernate.use_sql_comments"));
        //properties.setProperty("spring.jpa.hibernate.ddl-auto", env.getRequiredProperty("spring.jpa.hibernate.ddl-auto"));
        return properties;
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory(dataSource()).getObject());
        return transactionManager;
    }

    /*public PersistenceUnitManager persistenceUnitManager(){

    }*/
}

