package com.consumer.pokemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories 
@SpringBootApplication 
public class ConsumerPokemon1Application {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerPokemon1Application.class, args);
	}

}
