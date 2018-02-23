package com.museum.controller;


import com.museum.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactController {
    
    @Autowired
    AuthorService authorService;
    
    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("authorName", authorService.find(1).getLastName());
        return "index";
    }
}
