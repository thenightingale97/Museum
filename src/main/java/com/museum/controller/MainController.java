package com.museum.controller;


import com.museum.entity.Showpiece;
import com.museum.service.EventService;
import com.museum.service.GuideService;
import com.museum.service.ShowpieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    ShowpieceService showpieceService;

    @Autowired
    EventService eventService;

    @Autowired
    GuideService guideService;

    @RequestMapping("/")
    public String main(Model model) {
        List<Showpiece> allByRandom = showpieceService.findAllByRandom(3);
        model.addAttribute("showpieces", allByRandom);
        model.addAttribute("upcomingEvents", eventService.findAllUpcomingOrderedByDate(3));
        return "excursion";
    }


    @RequestMapping(value = "/showpiece", method = RequestMethod.GET)
    public ModelAndView showpiece(@RequestParam("showpieceId") int id) {
        ModelAndView modelAndView = new ModelAndView();
        Showpiece showpiece = showpieceService.find(id);
        modelAndView.addObject("showpiece", showpiece);
        modelAndView.setViewName("showpiece");
        return modelAndView;
    }


    @RequestMapping(value = "/showpieces", method = RequestMethod.GET)
    public String showPieces(Map<String, Object> model) {
        model.put("showpieces", showpieceService.findAll());
        return "showpieces";
    }


    @RequestMapping(value = "/guides", method = RequestMethod.GET)
    public String showGuides(Map<String, Object> model) {
        model.put("guides", guideService.findAll());
        return "guides";
    }


}
