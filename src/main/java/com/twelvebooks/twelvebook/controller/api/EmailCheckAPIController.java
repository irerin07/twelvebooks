package com.twelvebooks.twelvebook.controller.api;

import com.twelvebooks.twelvebook.dto.EmailDto;
import com.twelvebooks.twelvebook.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
@RequiredArgsConstructor
public class EmailCheckAPIController {

    @Autowired
    UserService userService;

    @PostMapping
    public int emailCheck(@RequestBody EmailDto emailDto){
        int emailCheck = userService.emailCheck(emailDto.getEmail());
        return emailCheck;
    }

}
