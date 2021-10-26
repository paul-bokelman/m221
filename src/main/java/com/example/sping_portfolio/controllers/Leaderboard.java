package com.example.sping_portfolio.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class Leaderboard {
    @GetMapping("/leaderboard")
    public String page(Model model) {

        String[] lb = {"Ishan", "Mort", "Yeonjoon"};
        model.addAttribute("firstP", lb[0]);
        model.addAttribute("secondP", lb[1]);
        model.addAttribute("thirdP", lb[2]);

        return "leaderboard";
    }
}