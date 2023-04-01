package com.j6d2.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.j6d2.bean.Student;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Controller
public class Student2Controller {
    @RequestMapping("/student/list")
    public String list(Model model, @RequestParam("index") Optional<Integer> index) throws Exception{
        //đọc danh sách dữ liệu từ file
        ObjectMapper mapper = new ObjectMapper();
        File file = new ClassPathResource("static/student2.json").getFile();
        TypeReference<List<Student>> typeref = new TypeReference<>() {};
        List<Student> list = mapper.readValue(file,typeref);
        System.out.println("testt--- "+ list);
        int i = index.orElse(0);

        model.addAttribute("now", new Date());
        model.addAttribute("dssv",list);
        model.addAttribute("sv",list.get(index.orElse(0)));
        return "student/list";
    }
}
