//package com.example.springexceptionhandling.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
//import java.util.Collection;
//import java.util.Collections;
//
///**
// * @author manhdt14
// * created in 10/7/2023 1:39 AM
// */
//@Configuration
//public class SwaggerConfiguration {
//    private ApiInfo apiInfo() {
//        return new ApiInfo("Blog REST APIs",
//                "REST API for Blog Application",
//                "1.0",
//                "Terms of service",
//                new Contact("MANH DO", null,"manhcntt2.1@gmail.com"),
//                "License of API",
//                "API license URL",
//                Collections.emptyList());
//    }
//
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build();
//    }
//}
