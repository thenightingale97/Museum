package com.museum.controller;

import com.museum.service.AuthorService;
import com.museum.service.ShowpieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Администратор on 01.03.18.
 */

@Controller
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @Autowired
    ShowpieceService showpieceService;

    @GetMapping("/authors")
    public String authors(Model model) {

        model.addAttribute("authors", authorService.findAll());
        return "authors";
    }

    @GetMapping("/author")
    public String author(Model model, @RequestParam("authorId") int id) {
        model.addAttribute("author", authorService.find(id));
        model.addAttribute("showpieces", showpieceService.findAllByAuthor(authorService.find(id)));
        return "author";
    }


}
