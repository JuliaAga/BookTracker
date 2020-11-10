package ru.books.BookTracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.books.BookTracker.repositories.AuthorRepository;

@Controller
public class AuthorController {
    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository bookRepository) {
        this.authorRepository = bookRepository;
    }

    @RequestMapping("/authors")
    public String getBooks(Model model){

        model.addAttribute("authors", authorRepository.findAll());

        return "authors/list";
    }
}
