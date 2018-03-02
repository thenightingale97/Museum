package com.museum.controller.admin;

import com.museum.entity.ShowpieceMaterial;
import com.museum.entity.ShowpieceTechnique;
import com.museum.model.request.ShowpieceRequest;
import com.museum.service.AuthorService;
import com.museum.service.HallService;
import com.museum.service.ShowpieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/showpiece")
public class AdminShowpieceController {

    @Autowired
    private ShowpieceService showpieceService;

    @Autowired
    private HallService hallService;

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public String showpiece(Model model) {
        model.addAttribute("showpieces", showpieceService.findAll());
        model.addAttribute("halls", hallService.findAll());
        model.addAttribute("authors", authorService.findAll());
        model.addAttribute("showpieceMaterials", ShowpieceMaterial.values());
        model.addAttribute("showpieceTechniques", ShowpieceTechnique.values());
        return "admin-showpiece";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("showpiece") ShowpieceRequest showpiece) {
        showpieceService.update(showpiece);
        return "redirect:/admin/showpiece";
    }

    @GetMapping("/updating/{id}")
    public String updating(@PathVariable Integer id, Model model) {
        model.addAttribute("showpiece", showpieceService.find(id));
        model.addAttribute("halls", hallService.findAll());
        model.addAttribute("authors", authorService.findAll());
        return "admin-showpiece";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        showpieceService.delete(id);
        return "redirect:/admin/showpiece";
    }

    @ModelAttribute("showpiece")
    public ShowpieceRequest getForm() {
        return new ShowpieceRequest();
    }

}

