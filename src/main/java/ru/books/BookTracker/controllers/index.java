package ru.books.BookTracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class index {
    @RequestMapping("/")
    public String getStartPage(Model model){
        return "index";
    }
}
