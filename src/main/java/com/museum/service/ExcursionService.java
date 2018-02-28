package com.museum.service;

import com.museum.entity.Excursion;
import com.museum.model.request.ExcursionRequest;

public interface ExcursionService extends Service<Excursion, Integer> {
    void update(ExcursionRequest excursion);
}
