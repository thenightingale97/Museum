package com.museum.repository;

import com.museum.entity.Guide;
import com.museum.entity.GuidePosition;

import java.util.List;

public interface GuideRepository extends Repository<Guide, Integer> {
    
    List<Guide> findByPosition(GuidePosition position);
}
