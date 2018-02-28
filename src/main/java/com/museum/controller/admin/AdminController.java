package com.museum.controller.admin;

import com.museum.model.view.AuthorView;
import com.museum.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public String admin(Model model) {
        model.addAttribute("authors", authorService.findAll());
        return "admin";
    }

    @PostMapping
    public String addAuthor(@ModelAttribute("authorView") AuthorView authorView) {
        authorService.save(authorView);
        return "redirect:/admin";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        authorService.delete(id);
        return "redirect:/admin";
    }

    @RequestMapping("/update/{id}")
    public String update(@PathVariable int id, Model model){
        model.addAttribute("authorView", authorService.find(id));
        return "admin";
    }

    @ModelAttribute("authorView")
    public AuthorView getForm() {
        return new AuthorView();
    }
}
