package com.museum.controller.admin;

import com.museum.entity.Author;
import com.museum.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public String author(Model model) {
        model.addAttribute("authors", authorService.findAll());
        return "admin-author";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("author") Author author) {
        authorService.update(author);
        return "redirect:/admin/author";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        authorService.delete(id);
        return "redirect:/admin/guardian";
    }

    @RequestMapping("/updating/{id}")
    public String update(@PathVariable int id, Model model){
        model.addAttribute("author", authorService.find(id));
        return "admin-author";
    }

    @ModelAttribute("author")
    public Author getForm() {
        return new Author();
    }

}
