package com.example.springexceptionhandling;

import com.example.springexceptionhandling.exception.type.ResourceNotFoundException;
import com.example.springexceptionhandling.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringExceptionHandlingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringExceptionHandlingApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner load(PostRepository postRepository) {
//        return args -> {
//            postRepository.findById(2L).orElseThrow(() -> new ResourceNotFoundException("/api/v1/post", "id", 2));
//        };
//    }
}
