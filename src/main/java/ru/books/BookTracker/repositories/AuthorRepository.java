package ru.books.BookTracker.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.books.BookTracker.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
