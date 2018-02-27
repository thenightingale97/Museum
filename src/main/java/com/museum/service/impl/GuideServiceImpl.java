package com.museum.service.impl;

import com.museum.entity.Guide;
import com.museum.entity.GuidePosition;
import com.museum.repository.GuideRepository;
import com.museum.service.AbstractService;
import com.museum.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class GuideServiceImpl extends AbstractService<Guide, Integer, GuideRepository> implements GuideService {
    
    @Autowired
    private GuideRepository repository;
    
    @Override
    public GuideRepository getRepository() {
        return repository;
    }
    
    private static void checkPeriod(LocalDateTime fromTime, LocalDateTime toTime) {
        Objects.requireNonNull(fromTime, "fromTime");
        Objects.requireNonNull(toTime, "toTime");
        if (fromTime.isAfter(toTime)) {
            throw new IllegalArgumentException(
                    "Parameter 'fromTime' can`t be greater than 'toTime'.");
        }
    }
    
    @Override
    public List<Guide> findAllByPosition(GuidePosition position) {
        Objects.requireNonNull(position, "position");
        return getRepository().findAllByPosition(position);
    }
    
    @Override
    public List<Guide> findAllByPeriod(LocalDateTime fromTime, LocalDateTime toTime) {
        checkPeriod(fromTime, toTime);
        return getRepository().findAllByPeriod(fromTime, toTime);
    }

    @Override
    public Long getWorkTime(int guideId) {
        return getRepository().getWorkTime(guideId);
    }
    
    @Override
    public Long getWorkTimeByPeriod(int guidId, LocalDateTime fromTime, LocalDateTime toTime) {
        checkPeriod(fromTime, toTime);
        return getRepository().getWorkTimeByPeriod(guidId, fromTime, toTime);
    }
}
