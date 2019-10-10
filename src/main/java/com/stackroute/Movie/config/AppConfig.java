//package com.stackroute.Movie.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import static springfox.documentation.builders.PathSelectors.regex;
//
//
//@Configuration
//@EnableSwagger2
//public class AppConfig {
//
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.stackroute.Movie.controller"))
//                .paths(regex("/api.*"))
//                .build();
//    }
//
//
//    @Bean
//    @Profile("dev")
//    public String devBean(){
//        return "I am available in profile dev";
//    }
//
//    @Bean
//    @Profile("prod")
//    public String prodBean(){
//        return "I am available in profile prod";
//    }
//
//
//}
