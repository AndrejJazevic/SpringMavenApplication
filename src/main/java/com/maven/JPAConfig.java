/*
package com.maven;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@EnableTransactionManagement
@PropertySource("classpath:application.properties")
@Configuration
public class JPAConfig {

    private Environment env;
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(env.getRequiredProperty("org.h2.Driver"));
        ds.setUrl(env.getRequiredProperty("jdbc:h2:~/h2database/OnlineShopDB"));
        ds.setUsername(env.getRequiredProperty("sa"));
        ds.setPassword(env.getRequiredProperty("sa"));
        return ds;
    }
}
*/
