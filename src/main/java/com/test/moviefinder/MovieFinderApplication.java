package com.test.moviefinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author Darshan Mehta
 * This is a starting point of movie finder application
 */
@SpringBootApplication
public class MovieFinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieFinderApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
