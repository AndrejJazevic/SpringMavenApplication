package com.maven;

import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@EnableTransactionManagement
public class Main {
    private static AnnotationConfigApplicationContext ctx;

    public static void main(String[] args) {

        ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        System.out.println("Hello");
    }
}