package com.twelvebooks.twelvebook.controller.api;

import com.twelvebooks.twelvebook.domain.Challenge;
import com.twelvebooks.twelvebook.service.ChallengeService;
import com.twelvebooks.twelvebook.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/challenge")
@RequiredArgsConstructor
public class ChallengeAPIController {

    @Autowired
    ChallengeService challengeService;

    @Autowired
    UserService userService;

    @GetMapping
    public List<Challenge> getChallenge(@RequestParam(name = "userId") Long id){
        List<Challenge> list = challengeService.getChallengesByUserId(id);
        for(Challenge challenge : list){
            System.out.println(challenge.getBooksTitle());
        }
        return list;
    }


}
