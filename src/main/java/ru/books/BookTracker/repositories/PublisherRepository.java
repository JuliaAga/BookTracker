package ru.books.BookTracker.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.books.BookTracker.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
