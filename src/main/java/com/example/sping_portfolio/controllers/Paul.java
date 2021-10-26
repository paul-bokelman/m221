package com.example.sping_portfolio.controllers;
import com.example.sping_portfolio.PaulLab;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class Paul {
    @GetMapping("/paul")

    // Abstract class


    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings

    public String page(Model model) {

        PaulLab P = new PaulLab();
        PaulLab.Methods P2 = P.new Methods();
        int[] data = P2.main();

        model.addAttribute("data", data); 
        return "paul"; 
    }
}