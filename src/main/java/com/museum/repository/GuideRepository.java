package com.museum.repository;

import java.util.List;

import com.museum.entity.Guide;
import com.museum.entity.GuidePosition;

public interface GuideRepository extends Repository<Guide, Integer> {
  
    List<Guide> getGuideByPosition(GuidePosition position);

}
