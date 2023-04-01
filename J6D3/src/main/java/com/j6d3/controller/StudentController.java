package com.j6d3.controller;

import com.j6d3.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
    @RequestMapping("/student/form")
    public String form(Model model){
        Student student = new Student();
        model.addAttribute("sv",student);
        return "student/form";
    }

    @PostMapping("/student/save")
    public String save(@ModelAttribute("sv") Student form){
        return "student/success";
    }
}
