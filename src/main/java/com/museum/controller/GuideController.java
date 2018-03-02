package com.museum.controller;

import com.museum.entity.GuidePosition;
import com.museum.model.filter.GuideFilter;
import com.museum.model.request.GuideFilterRequest;
import com.museum.model.statistic.GuideStatistic;
import com.museum.model.view.GuideView;
import com.museum.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class GuideController {

    @Autowired
    GuideService guideService;

    @RequestMapping("/guides")
    public String guides(Model model, @ModelAttribute GuideFilterRequest guideFilterRequest) {
        List<GuideStatistic> guideStatistics =
                guideService.findAllByFilterWithStatistic(GuideFilter.of(guideFilterRequest));
        List<GuideView> guideViews = GuideView.listOfStatistics(guideStatistics);
        model.addAttribute("guideViews", guideViews);
        model.addAttribute("guidePositions", GuidePosition.values());
        return "guides";
    }

    @ModelAttribute("guideFilterRequest")
    public GuideFilterRequest populateGuideFilter() {
        return new GuideFilterRequest();
    }
}
