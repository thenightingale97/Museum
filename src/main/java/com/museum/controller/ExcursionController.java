package com.museum.controller;

import com.museum.entity.Event;
import com.museum.model.request.PeriodRequest;
import com.museum.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Controller
@RequestMapping("/excursions")
public class ExcursionController {
    
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    

    @Autowired
    EventService eventService;
    
    private static LocalDateTime parseDateTimeNullable(String dateTime) {
        try {
            return LocalDateTime.parse(dateTime, DATE_TIME_FORMATTER);
        } catch (DateTimeParseException ex) {
            return null;
        }
    }
    
    @GetMapping
    public String excursions(Model model,
                             @ModelAttribute PeriodRequest periodRequest) {
        LocalDateTime fromDateTime = parseDateTimeNullable(periodRequest.getFromDateTime());
        LocalDateTime toDateTime = parseDateTimeNullable(periodRequest.getToDateTime());
    
        List<Event> events;
        if (fromDateTime == null && toDateTime == null) {
            events = eventService.findAll();
        } else if (fromDateTime == null) {
            events = eventService.findAllByToTime(toDateTime);
        } else if (toDateTime == null) {
            events = eventService.findAllByFromTime(fromDateTime);
        } else {
            events = eventService.findAllByPeriod(fromDateTime, toDateTime);
        }
        model.addAttribute("events", events);
        return "excursions";
    }

}
