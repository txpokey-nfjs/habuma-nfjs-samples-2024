package habuma.reactivebooksclient;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import reactor.core.publisher.Mono;

@HttpExchange(url="http://localhost:8080")
public interface BooksClient {

    @GetExchange("/books/{id}")
    Mono<Book> getBookById(@PathVariable("id") Long id);

}
