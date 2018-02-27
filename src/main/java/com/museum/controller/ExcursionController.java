package com.museum.controller;

import com.museum.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/excursions")
public class ExcursionController {

    @Autowired
    EventService eventService;

    @GetMapping
    public String excursions(Model model) {
        model.addAttribute("events", eventService.findAll());
        return "excursions";
    }

}
