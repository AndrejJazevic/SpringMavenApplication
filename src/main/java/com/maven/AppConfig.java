package com.maven;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.DefaultPersistenceUnitManager;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitManager;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
//@EnableJpaRepositories("com.maven.repository")
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
        factory.setPersistenceUnitManager(persistenceUnitManager());
        factory.setPackagesToScan("com.maven.entity");
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        //factory.setJpaVendorAdapter(jpaVendorAdapter());
        return factory;
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory(dataSource()).getObject());
        return transactionManager;
    }

    @Bean
    public PersistenceUnitManager persistenceUnitManager(){
        DefaultPersistenceUnitManager persistenceUnitManager = new DefaultPersistenceUnitManager();
        persistenceUnitManager.setPersistenceXmlLocation("classpath*:/META-INF/persistence.xml");
        persistenceUnitManager.setDefaultDataSource(dataSource());
        return persistenceUnitManager;
    }

    private Properties properties(){
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
        properties.setProperty("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
        properties.setProperty("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
        properties.setProperty("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
        properties.setProperty("hibernate.use_sql_comments", env.getRequiredProperty("hibernate.use_sql_comments"));
        return properties;
    }

    /*private JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.H2);
        adapter.setDatabasePlatform(env.getRequiredProperty("hibernate.dialect"));
        adapter.setShowSql(env.getRequiredProperty("hibernate.show_sql",Boolean.class));
        return adapter;
    }*/
}

