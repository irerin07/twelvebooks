package com.twelvebooks.twelvebook.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/challenges")
@RequiredArgsConstructor
public class ChallengeController {

    @GetMapping("/addform")
    public String addform(){
        return "challenges/addform";
    }



    }
