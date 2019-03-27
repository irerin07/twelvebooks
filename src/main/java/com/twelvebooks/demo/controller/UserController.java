package com.twelvebooks.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {


    @GetMapping("/login")
    public String login(
            @RequestParam(name = "fail",
                    required = false,
                    defaultValue = "false") String errorFlag){
        return "users/login";
    }

    @GetMapping("/join")
    public String joinForm(){
        return "users/join";
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "users/index";
    }

    @GetMapping("/challenge")
    public String challenge(){
        return "users/challenge";
    }

    @GetMapping("/delete")
    public String delete(){
        return "users/delete";
    }
}
