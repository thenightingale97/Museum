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
        model.addAttribute("showpiece0", showpieceService.getShowpieceRandomList().get(0));
        model.addAttribute("showpiece1", showpieceService.getShowpieceRandomList().get(1));
        model.addAttribute("showpiece2", showpieceService.getShowpieceRandomList().get(2));

        model.addAttribute("event0", eventService.findEventOrderedByDate().get(0));
        model.addAttribute("event1", eventService.findEventOrderedByDate().get(1));
        model.addAttribute("event2", eventService.findEventOrderedByDate().get(2));
        return "index";
    }


    @RequestMapping("/excursions")
    public String excursions(Model model) {
        return "excursions";
    }
}
