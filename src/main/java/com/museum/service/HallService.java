package com.museum.service;

import com.museum.entity.Hall;
import com.museum.model.view.HallView;

public interface HallService extends Service<Hall, Integer> {
    void update(HallView hallView);
}
