package com.museum.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.museum.entity.Event;

public interface EventRepository extends Repository<Event, Integer> {
    
    List<Event> getByPeriod(LocalDateTime fromTime, LocalDateTime toTime);
    
    Long getAmountByPeriod(LocalDateTime fromTime, LocalDateTime toTime);
    
}
