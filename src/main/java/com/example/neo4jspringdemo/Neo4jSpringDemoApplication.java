package com.example.neo4jspringdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class Neo4jSpringDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(Neo4jSpringDemoApplication.class, args);
    }

}
