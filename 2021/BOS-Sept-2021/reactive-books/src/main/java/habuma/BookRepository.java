package habuma;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookRepository 
		extends ReactiveCrudRepository<Book, String>{

	Mono<Book> findByIsbn(String isbn);
	
	Flux<Book> findByAuthor(String author);
	
}
