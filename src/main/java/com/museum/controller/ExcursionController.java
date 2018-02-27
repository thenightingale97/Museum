package com.museum.controller;

import com.museum.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.WeekFields;

@Controller
@RequestMapping("/excursions")
public class ExcursionController {

    @Autowired
    EventService eventService;

    @GetMapping
    public String excursions(Model model,
                             @RequestParam(required = false) String fromDate,
                             @RequestParam(required = false) String toDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        if(fromDate == null || toDate == null) {
            model.addAttribute("events", eventService.findAll());
        }
        else {
            model.addAttribute("events", eventService.findByPeriod(LocalDateTime.parse(fromDate, formatter), LocalDateTime.parse(toDate, formatter)));
        }
        return "excursions";
    }

}
