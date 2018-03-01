package com.museum.controller;

import com.museum.entity.Event;
import com.museum.model.filter.EventFilter;
import com.museum.model.request.EventFilterRequest;
import com.museum.model.view.EventView;
import com.museum.service.EventService;
import com.museum.service.ExcursionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class EventController {

    @Autowired
    EventService eventService;

    @Autowired
    ExcursionService excursionService;

    @RequestMapping("/events")
    public String excursions(Model model, @ModelAttribute EventFilterRequest eventFilterRequest) {
        List<Event> events = eventService.findAllByFilter(EventFilter.of(eventFilterRequest));
        List<EventView> eventViews = EventView.ofAll(events);

        model.addAttribute("startTime","початкова дата");
        model.addAttribute("endTime", "кінцева дата");
        model.addAttribute("number", eventViews.size() );
        model.addAttribute("eventItemViews", eventViews);
        model.addAttribute("excursions", excursionService.findAll());
       // eventViews
        return "events";
    }

    @ModelAttribute("eventFilterRequest")
    public EventFilterRequest populateEventFilterRequest() {
        return new EventFilterRequest();
    }
}
