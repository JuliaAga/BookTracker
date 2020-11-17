package ru.books.BookTracker.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.books.BookTracker.domain.Author;

import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    List<Author> findByLastNameIgnoreCaseLike (String lastName);
}
