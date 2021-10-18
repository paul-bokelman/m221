package com.example.sping_portfolio.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class Alive {
    @GetMapping("/alive")
    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings


    public String page(Model model) {
        Object[][] names = {{"Ishan", "ishaank", false}, 
        {"Justin", "justinli", false}, 
        {"Luca", "lucapinto", false}, 
        {"Mort MORT MORT!", "mort", false}, 
        {"Paul", "paulbok", false}, 
        {"Rohan", "rohankos", false}, 
        {"Roop", "roops", false},
        {"Ryan", "ryanmog", false}, 
        {"Sammy", "sammahj", false}, 
        {"Yeonjoon", "yeongjoong", false}};
        model.addAttribute("names", names);
        model.addAttribute("grayscale", false);
        return "alive"; // returns HTML VIEW (greeting)
    }
}

