package com.example.demo;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookRepository 
	extends ReactiveCrudRepository<Book, String> {

	Mono<Book> findByIsbn(String isbn);
	
	Mono<SimpleBook> findSimpleByIsbn(String isbn);
	
	@Query("{author:'Kendall Crolius'}")
	Flux<Book> kendallsBooks();
	
}
