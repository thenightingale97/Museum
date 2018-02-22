package com.museum.service;

import java.time.LocalDateTime;
import java.util.List;

import com.museum.entity.Guide;
import com.museum.entity.GuidePosition;

public interface GuideService extends Service<Guide, Integer> {
    
    List<Guide> getGuideByPosition(GuidePosition position);
    
    Long getEventAmount(int guidId);
    
    Long getEventAmountByPeriod(int guidId, LocalDateTime fromTime, LocalDateTime toTime);

}
