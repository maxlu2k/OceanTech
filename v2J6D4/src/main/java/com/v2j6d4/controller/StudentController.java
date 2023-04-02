package com.v2j6d4.controller;

import com.v2j6d4.bean.Contact;
import com.v2j6d4.bean.Student;
import com.v2j6d4.dao.StudentDao;
import com.v2j6d4.map.StudentMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
    @Autowired
    StudentDao dao;
    @RequestMapping("/student/index")
    public String index(Model model){
        Student student = new Student("dung",5.0,true,new Contact("dung@gmail.com","VN"));
        model.addAttribute("form", student);
        StudentMap map = dao.findAll();
        model.addAttribute("items",map);
        return "student/index";
    }

    @RequestMapping("/student/edit/{key}")
    public String edit(Model model, @PathVariable("key") String key){
        model.addAttribute(("key"),key);
        Student student = dao.findByKey(key);
        model.addAttribute("form",student);
        StudentMap map = dao.findAll();
        model.addAttribute("items", map);
        return "student/index";
    }
}
