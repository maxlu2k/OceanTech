package com.j6d2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OperatorController {
    @RequestMapping("/demo/operator")
    public String Demo(Model model){
        model.addAttribute("x", 5);
        model.addAttribute("y", 7);
        return "scope/operator";
    }
}
