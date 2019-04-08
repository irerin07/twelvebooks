package com.twelvebooks.twelvebook.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admins")
@RequiredArgsConstructor
public class AdminController {

    @GetMapping("/admin")
    public String userList(){
        return "admin/admin";
    }

    @GetMapping("/challengelist")
    public String challengelist(){
        return "admin/challengelist";
    }
}
