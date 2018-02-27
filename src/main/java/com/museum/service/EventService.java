package com.museum.service;

import com.museum.entity.Event;
import com.museum.entity.Guide;

import java.time.LocalDateTime;
import java.util.List;


public interface EventService extends Service<Event, Integer> {
    
    List<Event> findAllByPeriod(LocalDateTime fromTime, LocalDateTime toTime);
    
    List<Event> findAllByFromTime(LocalDateTime fromTime);
    
    List<Event> findAllByToTime(LocalDateTime toTime);
    
    Long getAmountByPeriod(LocalDateTime fromTime, LocalDateTime toTime);
    
    Long getAmountByGuide(Guide guide);
    
    Long getAmountByGuideAndPeriod(Guide guide, LocalDateTime fromTime, LocalDateTime toTime);
    
    List<Event> findAllUpcomingOrderedByDate(int limit);
}
