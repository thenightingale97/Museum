package com.museum.controller;


import com.museum.entity.Showpiece;
import com.museum.service.EventService;
import com.museum.service.ExcursionService;
import com.museum.service.GuideService;
import com.museum.service.ShowpieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    ShowpieceService showpieceService;

    @Autowired
    EventService eventService;

    @Autowired
    GuideService guideService;

    @Autowired
    ExcursionService excursionService;

    @RequestMapping("/")
    public String main(Model model) {
        List<Showpiece> allByRandom = showpieceService.findAllByRandom(3);
        model.addAttribute("showpieces", allByRandom);
        model.addAttribute("upcomingEvents", eventService.findAllUpcomingOrderedByDate(3));
        return "index";
    }

    @GetMapping("/statistic")
    public String statistic(Model model){
        model.addAttribute("statisticByMaterials", showpieceService.getStatisticByMaterial());
        model.addAttribute("statisticByTechnique", showpieceService.getStatisticByTechnique());
        return "statistic";
    }


}
