package books;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BooksController {

	private final BookRepository repo;
	
	@GetMapping
	public Iterable<Book> allBooks() {
		return repo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Book> byId(@PathVariable("id") Long id) {
		return repo.findById(id);
	}
	
	@PostMapping
	public Book save(@RequestBody Book book) {
		return repo.save(book);
	}
	
}
