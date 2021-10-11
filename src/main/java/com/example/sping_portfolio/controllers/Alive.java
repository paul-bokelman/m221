package com.example.sping_portfolio.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class Alive {
    @GetMapping("/alive")
    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings


    public String page(Model model) {
            String[] arr = {"images/ishaan.jpg","images/justinli.jpg","images/lucapinto.jpg","images/mort.jpg","images/paulbok.jpg","images/rohankos.jpg","images/roop.jpg","images/rynamog.jpg","images/sammahj.jpg","images/yeongjoong.jpg"};
        model.addAttribute("arr", arr);

        return "alive"; // returns HTML VIEW (greeting)
    }
}

