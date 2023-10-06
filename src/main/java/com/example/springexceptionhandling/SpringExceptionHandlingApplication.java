package com.example.springexceptionhandling;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringExceptionHandlingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringExceptionHandlingApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
//    @Bean
//    public CommandLineRunner load(PostRepository postRepository) {
//        return args -> {
//            postRepository.findById(2L).orElseThrow(() -> new ResourceNotFoundException("/api/v1/post", "id", 2));
//        };
//    }
}
