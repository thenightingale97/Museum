package com.museum.service;

import com.museum.entity.Hall;
import com.museum.model.request.HallRequest;

public interface HallService extends Service<Hall, Integer> {
    void update(HallRequest hallView);
}
