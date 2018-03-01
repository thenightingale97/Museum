package com.museum.controller;


import com.museum.entity.Showpiece;
import com.museum.entity.ShowpieceMaterial;
import com.museum.service.EventService;
import com.museum.service.ExcursionService;
import com.museum.service.GuideService;
import com.museum.service.ShowpieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Iterator;
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

    @Autowired
    ExcursionService excursionService;

    @RequestMapping("/")
    public String main(Model model) {
        List<Showpiece> allByRandom = showpieceService.findAllByRandom(3);
        model.addAttribute("showpieces", allByRandom);
        model.addAttribute("upcomingEvents", eventService.findAllUpcomingOrderedByDate(3));
        return "index";
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


    @RequestMapping(value = "/statisticByShowpieces", method = RequestMethod.GET)
    public String statisticByShowpieces(Map<String, Object> model) {

        model.put("statisticByMaterials", showpieceService.getStatisticByMaterial());
        model.put("statisticByTechique", showpieceService.getStatisticByTechnique());
            return "statisticByShowpieces";
    }


    @RequestMapping(value = "/statisticByExcursion", method = RequestMethod.GET)
    public String statisticByExcursion(Map<String, Object> model) {
       /*  model.put("ExcursionStatistic", excursionService. );*/
          return "statisticByExcursion";
    }

}
