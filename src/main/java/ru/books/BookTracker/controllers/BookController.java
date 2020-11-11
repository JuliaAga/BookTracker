package ru.books.BookTracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.books.BookTracker.domain.Author;
import ru.books.BookTracker.domain.Book;
import ru.books.BookTracker.repositories.BookRepository;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){

        model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("newBook", new Book());

        return "books/list";
    }

    @PostMapping("/books")
    public String create(@ModelAttribute("newBook") Book newBook) {
        bookRepository.save(newBook);
        return "redirect:/books";
    }
}
