package com.museum.service;

import java.util.List;

import com.museum.entity.Guide;
import com.museum.entity.GuidePosition;

public interface GuideService extends Service<Guide, Integer> {
    
    List<Guide> getGuideByPosition(GuidePosition position);
    
}
