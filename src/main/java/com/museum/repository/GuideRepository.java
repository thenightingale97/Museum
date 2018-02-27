package com.museum.repository;

import com.museum.entity.Guide;
import com.museum.entity.GuidePosition;

import java.time.LocalDateTime;
import java.util.List;

public interface GuideRepository extends Repository<Guide, Integer> {
    
    List<Guide> findAllByPosition(GuidePosition position);
    
    List<Guide> findAllByPeriod(LocalDateTime fromTime, LocalDateTime toTime);
    
    Long getWorkTime(int guideId);
    
    Long getWorkTimeByPeriod(int guideId, LocalDateTime fromTime, LocalDateTime toTime);
}
