package com.example.sping_portfolio.controllers;
import com.example.sping_portfolio.samlabs.Factorial;
import org.springframework.ui.Model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class SamUnit6 {
    @GetMapping("/samfactorial")
    public String factorial(Model model) {
        model.addAttribute("num", 5);
        model.addAttribute("result", Factorial.factorial_loop(5));
        return "sam";
    }

}
