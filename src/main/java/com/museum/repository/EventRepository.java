package com.museum.repository;

import com.museum.entity.Event;

import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository extends Repository<Event, Integer> {
    
    List<Event> findByPeriod(LocalDateTime fromTime, LocalDateTime toTime);
    
    Long getAmountByPeriod(LocalDateTime fromTime, LocalDateTime toTime);
    
    Long getAmountByGuide(int guidId);
    
    Long getAmountByPeriodAndGuide(int guidId, LocalDateTime fromTime, LocalDateTime toTime);
}
