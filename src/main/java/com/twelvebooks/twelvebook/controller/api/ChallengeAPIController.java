package com.twelvebooks.twelvebook.controller.api;

import com.twelvebooks.twelvebook.domain.Challenge;
import com.twelvebooks.twelvebook.domain.User;
import com.twelvebooks.twelvebook.dto.ChallengeDto;
import com.twelvebooks.twelvebook.service.ChallengeService;
import com.twelvebooks.twelvebook.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.mappers.ModelMapper;

import javax.xml.bind.helpers.PrintConversionEventImpl;
import java.security.Principal;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/challenges")
@RequiredArgsConstructor
public class ChallengeAPIController {

    @Autowired
    ChallengeService challengeService;

    @Autowired
    UserService userService;

    @GetMapping
    public List<Challenge> getChallenge(@RequestParam(name = "userId") Long id
                                        ){
        List<Challenge> list = challengeService.getChallengesByUserId(id);
        return list;
    }

//    @GetMapping
//    public List<Challenge> getChallenge(@RequestParam(name = "userId") Long id,
//                                        @RequestParam(name ="bookStatus") String status){
//        List<Challenge> list = challengeService.getChallengesByUserId(id, status);
//        for(Challenge challenge : list){
//            System.out.println(challenge.getBooksTitle());
//        }
//        return list;
//    }
    @PostMapping
    public String addChallenge(@RequestBody ChallengeDto challengeDto, Principal principal){

        System.out.println(challengeDto.toString());

        return "ok";
    }

}
