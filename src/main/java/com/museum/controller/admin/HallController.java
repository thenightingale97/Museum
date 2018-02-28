package com.museum.controller.admin;

import com.museum.model.view.HallView;
import com.museum.service.GuardianService;
import com.museum.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/hall")
public class HallController {

    @Autowired
    private HallService hallService;

    @Autowired
    private GuardianService guardianService;

    @PostMapping("/update")
    public String update(@ModelAttribute("hall") HallView hall){
        hallService.update(hall);
        return "redirect:/admin/hall";
    }

    @GetMapping("/updating/{id}")
    public String updating(Model model, @PathVariable Integer id){
        model.addAttribute("hall", hallService.find(id));
        model.addAttribute("guardians", guardianService.findAll());
        return "admin-hall";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        hallService.delete(id);
        return "redirect:/admin/hall";
    }

    @GetMapping
    public String hall (Model model){
        model.addAttribute("halls", hallService.findAll());
        model.addAttribute("guardians", guardianService.findAll());
        return "admin-hall";
    }

    @ModelAttribute("hall")
    public HallView getForm(){
        return new HallView();
    }

}
