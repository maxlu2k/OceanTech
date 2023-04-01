package com.j6d2.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.j6d2.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;

@Controller
public class HomeController {
    @RequestMapping("/home/index")
    public String index(Model model) throws Exception{
        model.addAttribute("message","Wellcom To Thymeleaf");

        ObjectMapper mapper= new ObjectMapper();
        String path="C:\\Users\\alvin\\IntelliJWork\\OceanTechL1\\J6D2\\src\\main\\resources\\static\\student.json";
        Student student = mapper.readValue(new File(path), Student.class); //read value để đọc toàn bộ dữ liệu vào đối tượng json
        model.addAttribute("sv", student);

        return "home/index";
    }
}
