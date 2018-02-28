package com.museum.service.impl;

import com.museum.entity.Excursion;
import com.museum.model.request.ExcursionRequest;
import com.museum.repository.ExcursionRepository;
import com.museum.service.AbstractService;
import com.museum.service.ExcursionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Duration;

@Service
public class ExcursionServiceImpl extends AbstractService<Excursion, Integer, ExcursionRepository> implements ExcursionService {

    @Autowired
    private ExcursionRepository repository;

    @Override
    public ExcursionRepository getRepository() {
        return repository;
    }

    @Override
    @Transactional
    public void update(ExcursionRequest excursionView) {
        Excursion excursion = new Excursion();
        excursion.setDescription(excursionView.getDescription());
        excursion.setName(excursionView.getName());
        excursion.setId(excursionView.getId());
        excursion.setDuration(Duration.ofMinutes(excursionView.getDuration()));
        excursion.setMaxVisitorAmount(excursionView.getMaxVisitorAmount());
        repository.update(excursion);
    }
}
