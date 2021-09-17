package com.example.sping_portfolio.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class Binary {
    @GetMapping("/binary")
    public String page(Model model) {
        model.addAttribute("binary", "bits");
        return "binary";
    }
}

