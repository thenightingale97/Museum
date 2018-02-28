package com.museum.service;

import com.museum.entity.Excursion;
import com.museum.model.view.ExcursionView;

public interface ExcursionService extends Service<Excursion, Integer> {
    void update(ExcursionView excursion);
}
