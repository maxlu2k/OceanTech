package com.j6d2.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ScopeController {
    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpSession session;

    @Autowired
    ServletContext servletContext;

    @RequestMapping("/scope")
    public String index(Model model){
        model.addAttribute("a","im in student!");
        request.setAttribute("b","im in Request Scope");
        session.setAttribute("c","im in Session Scope");//lưu những dữ liệu cho từng phiên làm việc dùng chung cho nhiều quest khác nhau của phiên đó(chia sẻ dữu liệu cho từng người khác nhau của phiên đó)
        servletContext.setAttribute("d","im in Application Scope");//chia sẻ cho nhiều người toàn bộ ứng dụng
        return "/scope/index";
    }
}
