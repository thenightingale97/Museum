package com.museum.controller;


import com.museum.entity.Showpiece;
import com.museum.service.EventService;
import com.museum.service.ShowpieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


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
    
    //@RequestMapping("/showpiece")
    @RequestMapping(value = "/showpiece", method = RequestMethod.GET)
    public ModelAndView showpiece() {
    //public String showpiece(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        Showpiece showpiece = showpieceService.find(1);

        modelAndView.addObject("showpiece", showpiece);
        modelAndView.setViewName("showpiece");

        return modelAndView;
     //   return "showpiece";
    }


}
