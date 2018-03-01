package com.museum.controller;

import com.museum.entity.Excursion;
import com.museum.model.view.ExcursionView;
import com.museum.service.ExcursionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExcursionController {

    @Autowired
    ExcursionService excursionService;

    @RequestMapping("/excursion/{id}")
    public String excursions(Model model, @PathVariable Integer id) {
        Excursion excursion = excursionService.find(id);
        if (excursion != null) {
            model.addAttribute("excursionView", ExcursionView.of(excursion));
            return "excursion";
        } else {
            return "index";
        }
    }
}
