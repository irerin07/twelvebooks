package com.twelvebooks.twelvebook.controller.api;

import com.twelvebooks.twelvebook.service.ChallengeService;
import com.twelvebooks.twelvebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class ChallengeAPIController {

    @Autowired
    ChallengeService challengeService;

    @Autowired
    UserService userService;

    
}
