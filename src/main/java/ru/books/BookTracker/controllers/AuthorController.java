package ru.books.BookTracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.books.BookTracker.domain.Author;
import ru.books.BookTracker.repositories.AuthorRepository;

@Controller
public class AuthorController {
    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getBooks(Model model){

        model.addAttribute("authors", authorRepository.findAll());

        return "authors/list";
    }

    @GetMapping("/new_authors")
    public String newPerson(@ModelAttribute("author") Author author) {
        return "authors/new";
    }

    @PostMapping("/authors")
    public String create(@ModelAttribute("author") Author author) {
        authorRepository.save(author);
        return "redirect:/authors";
    }
}
