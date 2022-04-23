package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
	
	Book findByIsbn(String isbn);
	
	SimpleBook findSimpleByIsbn(String isbn);
	
}
