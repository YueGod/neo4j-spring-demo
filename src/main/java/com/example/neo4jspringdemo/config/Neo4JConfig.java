//package com.example.neo4jspringdemo.config;
//
//import org.neo4j.graphdb.GraphDatabaseService;
//import org.neo4j.graphdb.Transaction;
//import org.neo4j.graphdb.factory.GraphDatabaseFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.annotation.PostConstruct;
//import java.io.File;
//
///**
// * @author YueGod
// * @since 2022/1/6
// */
//@Configuration
//public class Neo4JConfig {
//
//    private final String datadir;
//
//
//    public Neo4JConfig() {
//        this.datadir = "/file/neo4j/db";
//    }
//
//    @Bean
//    public GraphDatabaseService graphDatabaseService(){
//        return new GraphDatabaseFactory()
//                .newEmbeddedDatabase(new File(datadir));
//    }
//
//}
