package com.museum.service;

import java.time.LocalDateTime;
import java.util.List;

import com.museum.entity.Event;


public interface EventService extends Service<Event, Integer> {
    
    List<Event> getByPeriod(LocalDateTime fromTime, LocalDateTime toTime);
    
    Long getAmountByPeriod(LocalDateTime fromTime, LocalDateTime toTime);
}
