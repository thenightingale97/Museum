package com.museum.controller.admin;

import com.museum.entity.Guardian;
import com.museum.service.GuardianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/guardian")
public class AdminGuardianController {

    @Autowired
    private GuardianService guardianService;

    @GetMapping
    public String guardian(Model model) {
        model.addAttribute("guardians", guardianService.findAll());
        return "admin-guardian";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("guardian") Guardian guardian) {
        guardianService.update(guardian);
        return "redirect:/admin/guardian";
    }

    @GetMapping("/updating/{id}")
    public String updating(@PathVariable Integer id, Model model) {
        model.addAttribute("guardian", guardianService.find(id));
        return "admin-guardian";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        guardianService.delete(id);
        return "redirect:/admin/guardian";
    }

    @ModelAttribute("guardian")
    public Guardian getForm() {
        return new Guardian();
    }

}
