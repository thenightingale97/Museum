package com.museum.controller;


import com.museum.service.EventService;
import com.museum.service.ShowpieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    
    @Autowired
    ShowpieceService showpieceService;

    @Autowired
    EventService eventService;
    
    @RequestMapping("/")
    public String main(Model model) {
        model.addAttribute("showpiece0", showpieceService.getRandomShowpiece());
        model.addAttribute("showpiece1", showpieceService.getRandomShowpiece());
        model.addAttribute("showpiece2", showpieceService.getRandomShowpiece());

        model.addAttribute("upcomingEvents", eventService.findUpcomingEventsOrderedByDate());
//        model.addAttribute("event1", eventService.findUpcomingEventsOrderedByDate().get(1));
//        model.addAttribute("event2", eventService.findUpcomingEventsOrderedByDate().get(2));
        return "index";
    }


    @RequestMapping("/excursions")
    public String excursions(Model model) {
        return "excursions";
    }
    
    @RequestMapping("/showpiece")
    public String showpiece(Model model) {
        return "showpiece";
    }
}
