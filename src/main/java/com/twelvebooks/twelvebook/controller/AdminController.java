package com.twelvebooks.twelvebook.controller;

import com.twelvebooks.twelvebook.domain.User;
import com.twelvebooks.twelvebook.repository.UserRepository;
import com.twelvebooks.twelvebook.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String userList(Model model){
        List<User> users = userService.getUsers();
        System.out.println(users.get(10).getRoles());

        System.out.println(users.get(10).getRegdate());
        model.addAttribute("users", users);

        return "admin/admin";
    }

    @GetMapping("/challengelist")
    public String challengelist(){
        return "admin/challengelist";
    }
}
