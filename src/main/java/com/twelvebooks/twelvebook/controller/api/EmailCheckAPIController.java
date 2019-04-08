package com.twelvebooks.twelvebook.controller.api;

import com.twelvebooks.twelvebook.domain.User;
import com.twelvebooks.twelvebook.dto.EmailDto;
import com.twelvebooks.twelvebook.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/email")
@RequiredArgsConstructor
public class EmailCheckAPIController {

    @Autowired
    UserService userService;


    @GetMapping
    public User getUserByEmail(@RequestParam(name = "email") String email){
        User user = userService.getUserByEmail(email);

        return user;
    }

    @PostMapping
    public int emailCheck(@RequestBody EmailDto emailDto){
        System.out.println("testtestemailtest");
        int emailCheck = userService.emailCheck(emailDto.getEmail());
        return emailCheck;
    }

}
