package com.museum.controller;


import com.museum.entity.Showpiece;
import com.museum.service.EventService;
import com.museum.service.ShowpieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {
    
    @Autowired
    ShowpieceService showpieceService;

    @Autowired
    EventService eventService;
    
    @RequestMapping("/")
    public String main(Model model) {
        List<Showpiece> allByRandom = showpieceService.findAllByRandom(3);
        model.addAttribute("showpieces", allByRandom);
        model.addAttribute("upcomingEvents", eventService.findAllUpcomingOrderedByDate(3));
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
