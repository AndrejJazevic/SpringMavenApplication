package com.maven;

import com.maven.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@EnableTransactionManagement
@Component
public class Main {
    private static AnnotationConfigApplicationContext ctx;

    @Autowired
    private CustomerRepository customerRepository;

    public static void main(String[] args) {

        ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        System.out.println("Hello");
    }
}