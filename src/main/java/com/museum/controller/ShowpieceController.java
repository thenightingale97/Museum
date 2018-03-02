package com.museum.controller;

import com.museum.entity.Showpiece;
import com.museum.model.filter.ShowpieceFilter;
import com.museum.model.request.ShowpieceFilterRequest;
import com.museum.service.AuthorService;
import com.museum.service.GuardianService;
import com.museum.service.HallService;
import com.museum.service.ShowpieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ShowpieceController {

    @Autowired
    private ShowpieceService showpieceService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private HallService hallService;

    @Autowired
    private GuardianService guardianService;

    @GetMapping("/showpiece")
    public String showpiece(Model model, @RequestParam("showpieceId") int id) {
        model.addAttribute("showpiece", showpieceService.find(id));
        return "showpiece";
    }

    @GetMapping("/showpieces")
    public String showPieces(Model model, @ModelAttribute("showpieceFilterRequest")
            ShowpieceFilterRequest showpieceFilterRequest) {
        List<Showpiece> showpieces = showpieceService.findAllByFilter(ShowpieceFilter.of(showpieceFilterRequest));
        model.addAttribute("showpieces", showpieces);
        model.addAttribute("authors", authorService.findAll());
        model.addAttribute("halls", hallService.findAll());
        model.addAttribute("guardians", guardianService.findAll());
        return "showpieces";
    }


    @GetMapping("/statisticByShowpieces")
    public String statisticByShowpieces(Model model) {
        model.addAttribute("statisticByMaterials", showpieceService.getStatisticByMaterial());
        model.addAttribute("statisticByTechnique", showpieceService.getStatisticByTechnique());
        return "statisticByShowpieces";
    }

    @ModelAttribute("showpieceFilterRequest")
    public ShowpieceFilterRequest populateShowpieceFilterRequest() {
        return new ShowpieceFilterRequest();
    }
}
