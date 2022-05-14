package com.projectTP.web_recipes.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NavigationController {

    @PostMapping("/greeting")
    public String helloPage(){
        return null;
    }

    @PostMapping("/main")
    public String mainPage(){
        return null;
    }

    @GetMapping("/auth")
    public String Authorization(){
        return null;
    }

}
