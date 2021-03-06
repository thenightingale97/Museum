package com.museum.service;

import com.museum.entity.Event;
import com.museum.entity.Excursion;
import com.museum.entity.Guide;
import com.museum.model.filter.EventFilter;
import com.museum.model.request.EventRequest;

import java.time.LocalDateTime;
import java.util.List;


public interface EventService extends Service<Event, Integer> {

    List<Event> findAllByPeriod(LocalDateTime fromTime, LocalDateTime toTime);

    List<Event> findAllByFromTime(LocalDateTime fromTime);

    List<Event> findAllByToTime(LocalDateTime toTime);

    List<Event> findAllByExcursion(Excursion excursion);

    Long getAmountByPeriod(LocalDateTime fromTime, LocalDateTime toTime);

    Long getAmountByGuide(Guide guide);

    Long getAmountByGuideAndPeriod(Guide guide, LocalDateTime fromTime, LocalDateTime toTime);

    List<Event> findAllUpcomingOrderedByDate(int limit);

    void update(EventRequest event);

    List<Event> findAllByFilter(EventFilter filter);
}
