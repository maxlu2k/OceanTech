package com.j6d2.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.j6d2.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {
    @RequestMapping("/student")
    public String index(Model model, @RequestParam("index") Optional<Integer> index) throws Exception{
        //đọc danh sách dữ liệu từ file
        ObjectMapper mapper = new ObjectMapper();
        String path="C:\\Users\\alvin\\IntelliJWork\\OceanTechL1\\J6D2\\src\\main\\java\\com\\j6d2\\bean\\student.json";
//        File path = ResourceUtils.getFile("C:\\Users\\alvin\\IntelliJWork\\OceanTechL1\\J6D2\\src\\main\\java\\com\\j6d2\\bean\\student.json");
        TypeReference<List<Student>> typeref = new TypeReference<>() {};
        List<Student> students = mapper.readValue(new File(path),typeref);
        System.out.println("testt--- "+ students);
        int i = index.orElse(0);
        model.addAttribute("n",i);
        model.addAttribute("sv",students.get(i));
        return "/scope/stu2";
    }
}
