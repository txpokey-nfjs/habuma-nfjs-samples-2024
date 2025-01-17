package com.example.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReactiveBooks2Application {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveBooks2Application.class, args);
	}
	
	@Bean
	public ApplicationRunner dataLoader(BookRepository repo) {
		return args -> {
			repo.save(new Book(null, 
					"1111122222", 
					"Knitting with Dog Hair", 
					"Kendall Crolius"))
				.subscribe();
			repo.save(new Book(null, 
					"2222233333", 
					"Crafting with Cat Hair", 
					"Kaori Tsutaya"))
				.subscribe();
		};
	}

}
