package com.museum.controller;


import com.museum.service.EventService;
import com.museum.service.ShowpieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

@Controller
public class MainController {
    
    @Autowired
    ShowpieceService showpieceService;

    @Autowired
    EventService eventService;
    
    @RequestMapping("/")
    public String main(Model model) {
        model.addAttribute("showpieces", showpieceService.findAllByRandom(3));
        model.addAttribute("upcomingEvents", eventService.findAllUpcomingOrderedByDate(3));
        return "index";
    }
    
    @RequestMapping("/excursions")
    public String excursions(Model model) {
        model.addAttribute("events", eventService.findAll());
        return "excursions";
    }
    
    @RequestMapping("/excursions")
    public String excursions(
            @RequestParam("fromDateTime") String fromDateTimeParam,
            @RequestParam("toDateTime") String toDateTimeParam,
            Model model) {
        try {
            LocalDateTime fromDateTime = LocalDateTime.parse(fromDateTimeParam);
            LocalDateTime toDateTime = LocalDateTime.parse(toDateTimeParam);
            model.addAttribute("events", eventService.findAllByPeriod(fromDateTime, toDateTime));
        } catch (DateTimeParseException ex) {
            model.addAttribute("events", eventService.findAll());
        }
        return "excursions";
    }
    
    @RequestMapping("/showpiece")
    public String showpiece(Model model) {
        return "showpiece";
    }
}
