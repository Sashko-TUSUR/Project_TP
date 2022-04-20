package com.projectTP.web_recipes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class WebRecipesApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebRecipesApplication.class, args);
	}

}
