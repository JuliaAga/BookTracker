package ru.books.BookTracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.books.BookTracker.domain.Author;
import ru.books.BookTracker.domain.Book;
import ru.books.BookTracker.domain.Publisher;
import ru.books.BookTracker.repositories.AuthorRepository;
import ru.books.BookTracker.repositories.BookRepository;
import ru.books.BookTracker.repositories.PublisherRepository;

import java.util.HashSet;

@Controller
public class BookController {

    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    private final AuthorRepository authorRepository;

    public BookController(BookRepository bookRepository, PublisherRepository publisherRepository,
                          AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {

        model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("publishers", publisherRepository.findAll());
        model.addAttribute("authors", authorRepository.findAll());
        model.addAttribute("newBook", new Book());

        return "books/list";
    }

    @PostMapping("/books")
    public String create(@ModelAttribute("newBook") Book newBook) {
          bookRepository.save(newBook);
        return "redirect:/books";
    }
}
