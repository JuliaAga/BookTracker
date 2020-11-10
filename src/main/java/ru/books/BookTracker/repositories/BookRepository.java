package ru.books.BookTracker.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.books.BookTracker.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
