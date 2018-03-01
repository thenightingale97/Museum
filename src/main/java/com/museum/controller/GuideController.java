package com.museum.controller;

import com.museum.entity.Guide;
import com.museum.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/guides")
public class GuideController {

    @Autowired
    GuideService guideService;

    @GetMapping
    public String showGuides(Model model, @ModelAttribute("guide") Guide guide) {
        model.addAttribute("guides", guideService.findAll());
        model.addAttribute("guidesByPosition", guideService.findAllByPosition(guide.getPosition()));
        return "guides";
    }

    @ModelAttribute("guide")
    public Guide getForm(){
        return new Guide();
    }
}
