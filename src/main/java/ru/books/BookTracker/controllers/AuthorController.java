package ru.books.BookTracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.books.BookTracker.domain.Author;
import ru.books.BookTracker.repositories.AuthorRepository;

import java.util.Optional;

@Controller
public class AuthorController {
    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model) {

        model.addAttribute("authors", authorRepository.findAll());
        model.addAttribute("newAuthor", new Author());
        return "authors/list";
    }

    @PostMapping("/authors")
    public String create(@ModelAttribute("newAuthor") Author newAuthor) {
        authorRepository.save(newAuthor);
        return "redirect:/authors";
    }

    @RequestMapping("/authors/edit/{id}")
    public String editAuthor(Model model, @PathVariable("id") int id) {
        model.addAttribute("author", authorRepository.findById((long) id).get());
        return "authors/edit";
    }

    @PostMapping("/authors/edit/{id}")
    public String update(@ModelAttribute("author") Author author) {
        authorRepository.save(author);
        return "redirect:/authors";
    }
}
