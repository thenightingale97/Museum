package com.museum.controller;

import com.museum.entity.Event;
import com.museum.model.request.EventFilterRequest;
import com.museum.model.view.EventView;
import com.museum.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Controller
public class EventController {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Autowired
    EventService eventService;

    private static LocalDateTime parseDateTimeNullable(String dateTime) {
        if (dateTime == null) {
            return null;
        }
        try {
            return LocalDateTime.parse(dateTime, DATE_TIME_FORMATTER);
        } catch (DateTimeParseException ex) {
            return null;
        }
    }

    @RequestMapping("/excursions")
    public String excursions(Model model,
                             @ModelAttribute EventFilterRequest eventsFilterRequest) {
        LocalDateTime fromDateTime = parseDateTimeNullable(eventsFilterRequest.getFromDateTime());
        LocalDateTime toDateTime = parseDateTimeNullable(eventsFilterRequest.getToDateTime());

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
        model.addAttribute("eventItemViews", EventView.ofAll(events));
        return "excursions";
    }

    @RequestMapping("/excursion/{id}")
    public String excursions(Model model, @PathVariable Integer id) {
        Event event = eventService.find(id);
        if (event != null) {
            model.addAttribute("event", event);
            return "excursion";
        } else {
            return "excursions";
        }
    }

    @ModelAttribute("eventsFilterRequest")
    public EventFilterRequest getExcursionsFilterRequest() {
        return new EventFilterRequest();
    }
}
