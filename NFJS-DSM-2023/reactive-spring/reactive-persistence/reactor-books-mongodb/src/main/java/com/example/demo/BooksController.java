package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class BooksController {

	private BookRepository repo;

	public BooksController(BookRepository repo) {
		this.repo = repo;
	}
	
	@GetMapping
	public Flux<Book> allBooks() {
		return repo.findAll();
	}
	
	@GetMapping("/{isbn}")
	public Mono<Book> oneBook(@PathVariable("isbn") String isbn) {
		return repo.findByIsbn(isbn);
	}
	
	@GetMapping("/{isbn}/simple")
	public Mono<SimpleBook> oneSimpleBook(@PathVariable("isbn") String isbn) {
		return repo.findSimpleByIsbn(isbn);
	}
	
	@PostMapping
	public Mono<Book> save(@RequestBody Book book) {
		return repo.save(book);
	}
	
}
