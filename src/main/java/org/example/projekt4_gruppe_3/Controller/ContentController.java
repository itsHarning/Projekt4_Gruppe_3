package org.example.projekt4_gruppe_3.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContentController {

    @GetMapping("/login")
    public String login(){
        return "Login";
    }

    @GetMapping("/register")
    public String register(){
        return "Register";
    }

    @GetMapping("/")
    public String placeholder(){
        return "Placeholder";
    }
}
