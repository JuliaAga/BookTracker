package ru.books.BookTracker.controllers;

import org.springframework.boot.autoconfigure.security.saml2.Saml2RelyingPartyAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.books.BookTracker.domain.Author;
import ru.books.BookTracker.domain.Book;
import ru.books.BookTracker.domain.Publisher;
import ru.books.BookTracker.repositories.PublisherRepository;

@Controller
public class PublisherController {
    private final PublisherRepository publisherRepository;

    public PublisherController(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @RequestMapping("/publishers")
    public String getPublishers(Model model){
        model.addAttribute("publishers", publisherRepository.findAll());
        model.addAttribute("newPublisher", new Publisher());
        return "publishers/list";
    }

    @PostMapping("/publishers")
    public String create(@ModelAttribute("newPublisher") Publisher newPublisher) {
        publisherRepository.save(newPublisher);
        return "redirect:/publishers";
    }

    @RequestMapping("/publishers/edit/{id}")
    public String editPublisher(Model model, @PathVariable("id") int id) {
        model.addAttribute("publisher", publisherRepository.findById((long) id).get());
        return "publishers/edit";
    }

    @PostMapping("/publishers/edit/{id}")
    public String update(@ModelAttribute("publisher") Publisher publisher) {
        publisherRepository.save(publisher);
        return "redirect:/publishers";
    }

}
