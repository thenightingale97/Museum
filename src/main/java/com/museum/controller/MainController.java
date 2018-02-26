package com.museum.controller;


import com.museum.service.AuthorService;
import com.museum.service.ShowpieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    
    @Autowired
    ShowpieceService showpieceService;

    @RequestMapping("/")
    public String getRandomShowpieces(Model model) {
        model.addAttribute("imageUrl", showpieceService.find(1).getImageUrl());
        return "index";
    }
}
