package com.j6d3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/layout")
    public String layout(){
        return "layout/layout";
    }
    @GetMapping("/home/index")
    public String index(Model model){
        return "home/index";
    }
    @GetMapping("/home/about")
    public String about(Model model){
        return "home/about";
    }
}
