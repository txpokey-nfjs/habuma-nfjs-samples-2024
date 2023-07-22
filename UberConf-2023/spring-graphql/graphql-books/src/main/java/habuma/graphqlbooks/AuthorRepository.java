package habuma.graphqlbooks;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.graphql.data.GraphQlRepository;

@GraphQlRepository
public interface AuthorRepository
        extends CrudRepository<Author, Long>, QueryByExampleExecutor<Author> {

    Author findByFirstNameAndLastName(String firstName, String lastName);
}
