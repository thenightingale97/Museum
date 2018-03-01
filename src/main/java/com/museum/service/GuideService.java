package com.museum.service;

import com.museum.entity.Guide;
import com.museum.entity.GuidePosition;
import com.museum.model.filter.GuideFilter;

import java.time.LocalDateTime;
import java.util.List;

public interface GuideService extends Service<Guide, Integer> {

    List<Guide> findAllByPosition(GuidePosition position);

    List<Guide> findAllByPeriod(LocalDateTime fromTime, LocalDateTime toTime);

    Long getWorkTimeByPeriod(Guide guide, LocalDateTime fromTime, LocalDateTime toTime);

    Long getWorkTime(Guide guide);

    List<Guide> findAllByFilter(GuideFilter filter);
}
