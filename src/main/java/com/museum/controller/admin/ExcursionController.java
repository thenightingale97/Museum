package com.museum.controller.admin;

import com.museum.model.request.ExcursionRequest;
import com.museum.service.ExcursionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/excursion")
public class ExcursionController {

    @Autowired
    private ExcursionService excursionService;

    @GetMapping
    public String excursion(Model model) {
        model.addAttribute("excursions", excursionService.findAll());
        return "admin-excursion";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("excursion") ExcursionRequest excursion) {
        excursionService.update(excursion);
        return "redirect:/admin/excursion";
    }

    @GetMapping("/updating/{id}")
    public String updating(@PathVariable Integer id, Model model) {
        model.addAttribute("excursion", excursionService.find(id));
        return "admin-excursion";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        excursionService.delete(id);
        return "redirect:/admin/excursion";
    }

    @ModelAttribute("excursion")
    public ExcursionRequest getForm() {
        return new ExcursionRequest();
    }


}
