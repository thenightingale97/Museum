package com.museum.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactController {
    
    @RequestMapping("/")
    public String home() {
        System.out.println("fjksdfjskldfjsldfjdslfj");
        return "index";
    }
}
