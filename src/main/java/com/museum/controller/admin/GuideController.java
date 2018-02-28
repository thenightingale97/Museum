package com.museum.controller.admin;

import com.museum.entity.Guide;
import com.museum.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/guide")
public class GuideController {

    @Autowired
    GuideService guideService;

    @GetMapping
    public String guide(Model model) {
        model.addAttribute("guides", guideService.findAll());
        return "admin-guide";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("guide") Guide guide) {
            guideService.update(guide);
        return "redirect:/admin/guide";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        guideService.delete(id);
        return "redirect:/admin/guide";
    }

    @RequestMapping("/updating/{id}")
    public String update(@PathVariable int id, Model model) {
        model.addAttribute("guide", guideService.find(id));
        return "admin-guide";
    }

    @ModelAttribute("guide")
    public Guide getForm() {
        return new Guide();
    }
}
