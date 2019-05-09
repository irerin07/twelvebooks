package com.twelvebooks.twelvebook.controller;


import com.sun.xml.internal.bind.v2.TODO;
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
import org.springframework.web.bind.annotation.RequestParam;

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

    //TODO 도전완료 한 페이지랑 도전중인 페이지를 나누어서 관리하기? 아니면 페이징 처리를 한번에 할 수 있나?
    @GetMapping("/library")
    public String library(
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            Model model){
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String email = loggedInUser.getName();

        User user = userService.getUserByEmail(email);

        List<Challenge> challengeList = challengeService.getChallengesByUserId(user.getId());
        List<Challenge> completedChal = challengeService.getChallengesByUserIdStatus(user.getId(), "완료");
        List<Challenge> onGoingChal = challengeService.getChallengesByUserIdStatus(user.getId(), "읽는중");

        List<Challenge> challenges = challengeService.getChallegesByUserId(user.getId(), page);

        model.addAttribute("user", user);
        model.addAttribute("challengeList", challengeList);
        model.addAttribute("completedChal", completedChal);
        model.addAttribute("onGoingChal", onGoingChal);

        return "challenges/library";
    }

    @GetMapping("/write")
    public String writeform(Model model) {
        return "challenges/writereview";}
    }
