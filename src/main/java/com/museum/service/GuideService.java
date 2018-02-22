package com.museum.service;

import com.museum.entity.Guide;
import com.museum.entity.GuidePosition;

import java.time.LocalDateTime;
import java.util.List;

public interface GuideService extends Service<Guide, Integer> {
    
    List<Guide> getGuideByPosition(GuidePosition position);
    
    List<Guide> findByPeriod(LocalDateTime fromTime, LocalDateTime toTime);
    
    Long getWorkTimeByPeriod(int guidId, LocalDateTime fromTime, LocalDateTime toTime);
    
    Long getWorkTime(int guideId);
}
