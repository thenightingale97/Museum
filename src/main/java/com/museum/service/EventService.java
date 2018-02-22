package com.museum.service;

import com.museum.entity.Event;

import java.time.LocalDateTime;
import java.util.List;


public interface EventService extends Service<Event, Integer> {
    
    List<Event> findByPeriod(LocalDateTime fromTime, LocalDateTime toTime);
    
    Long getAmountByPeriod(LocalDateTime fromTime, LocalDateTime toTime);
    
    Long getAmountByGuide(int guideId);
    
    Long getAmountByPeriodAndGuide(int guideId, LocalDateTime fromTime, LocalDateTime toTime);
}
