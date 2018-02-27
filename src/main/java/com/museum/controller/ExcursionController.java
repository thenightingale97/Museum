package com.museum.controller;

import com.museum.entity.Event;
import com.museum.model.request.PeriodRequest;
import com.museum.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.time.temporal.WeekFields;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/excursions")
public class ExcursionController {

    @Autowired
    EventService eventService;

    @GetMapping
    public String excursions(Model model,
                             @ModelAttribute PeriodRequest periodRequest) {
        String fromDateTimeParam = periodRequest.getFromDateTime();
        String toDateTimeParam = periodRequest.getToDateTime();
        List<Event> events = Collections.emptyList();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        if (fromDateTimeParam == null || toDateTimeParam == null || (fromDateTimeParam.isEmpty() && toDateTimeParam.isEmpty())) {
            model.addAttribute("events", eventService.findAll());
        } else {
            try {
                LocalDateTime fromDateTime = LocalDateTime.parse(fromDateTimeParam, formatter);
                LocalDateTime toDateTime = LocalDateTime.parse(toDateTimeParam, formatter);
                if (fromDateTimeParam.isEmpty()) {
                    events = eventService.findAllByToTime(toDateTime);
                } else if (toDateTimeParam.isEmpty()) {
                    events = eventService.findAllByFromTime(fromDateTime);
                } else {
                    events = eventService.findAllByPeriod(fromDateTime, toDateTime);
                }
            } catch (DateTimeParseException e) {
                events = Collections.emptyList();
            }
        }
        model.addAttribute("events", events);
        return "excursions";
    }

}
