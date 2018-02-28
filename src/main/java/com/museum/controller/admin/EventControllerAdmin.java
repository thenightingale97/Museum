package com.museum.controller.admin;

import com.museum.model.request.EventRequest;
import com.museum.service.EventService;
import com.museum.service.ExcursionService;
import com.museum.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/event")
public class EventControllerAdmin {

    @Autowired
    private EventService eventService;

    @Autowired
    private GuideService guideService;

    @Autowired
    private ExcursionService excursionService;

    @GetMapping
    public String event(Model model) {
        model.addAttribute("events", eventService.findAll());
        model.addAttribute("guides", guideService.findAll());
        model.addAttribute("excursions", excursionService.findAll());
        return "admin-event";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("event") EventRequest event) {
        eventService.update(event);
        return "redirect:/admin/event";
    }

    @GetMapping("/delete/{id}")
    public String delete (@PathVariable Integer id){
        eventService.delete(id);
        return "redirect:/admin/event";
    }

    @GetMapping("/updating/{id}")
    public String updating(@PathVariable Integer id, Model model){
        model.addAttribute("event", eventService.find(id));
        model.addAttribute("guides", guideService.findAll());
        model.addAttribute("excursions", excursionService.findAll());
        return "admin-event";
    }

    @ModelAttribute("event")
    public EventRequest getForm() {
        return new EventRequest();
    }

}
