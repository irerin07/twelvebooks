package com.twelvebooks.twelvebook.controller;


import com.twelvebooks.twelvebook.domain.Challenge;
import com.twelvebooks.twelvebook.domain.User;
import com.twelvebooks.twelvebook.service.ChallengeService;
import com.twelvebooks.twelvebook.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/challenges")
@RequiredArgsConstructor
public class ChallengeController {
    @Autowired
    ChallengeService challengeService;
    @Autowired
    UserService userService;

    @GetMapping("/addform")
    public String addform(){
        return "challenges/addform";
    }

    @GetMapping("/library")
    public String library(Model model){
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String email = loggedInUser.getName();

        User user = userService.getUserByEmail(email);

        List<Challenge> challengeList = challengeService.getChallengesByUserId(user.getId());
        model.addAttribute("user", user);
        model.addAttribute("challengeList", challengeList);
        return "challenges/library";
    }

    @GetMapping("/write")
    public String writeform(Model model) {
        return "challenges/writereview";}
    }
