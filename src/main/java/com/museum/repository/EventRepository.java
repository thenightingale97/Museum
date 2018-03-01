package com.museum.repository;

import com.museum.entity.Event;
import com.museum.entity.Excursion;
import com.museum.entity.Guide;
import com.museum.model.filter.EventFilter;

import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository extends Repository<Event, Integer> {

    List<Event> findAllByPeriod(LocalDateTime fromTime, LocalDateTime toTime);

    List<Event> findAllByFromTime(LocalDateTime fromTime);

    List<Event> findAllByToTime(LocalDateTime toTime);

    Long getAmountByPeriod(LocalDateTime fromTime, LocalDateTime toTime);

    Long getAmountByGuide(Guide guide);

    Long getAmountByPeriodAndGuide(Guide guide, LocalDateTime fromTime, LocalDateTime toTime);

    List<Event> findAllUpcomingOrderedByDate(int limit);

    List<Event> findAllByExcursion(Excursion excursion);

    List<Event> findAllByFilter(EventFilter filter);
}
