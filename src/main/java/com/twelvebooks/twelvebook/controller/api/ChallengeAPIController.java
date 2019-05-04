package com.twelvebooks.twelvebook.controller.api;

import com.twelvebooks.twelvebook.domain.Book;
import com.twelvebooks.twelvebook.domain.Challenge;
import com.twelvebooks.twelvebook.domain.User;
import com.twelvebooks.twelvebook.dto.ChallengeDto;
import com.twelvebooks.twelvebook.service.BookService;
import com.twelvebooks.twelvebook.service.ChallengeService;
import com.twelvebooks.twelvebook.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

//    @Autowired
//    BookService bookService;


    @GetMapping
    public List<Challenge> getChallenge(@RequestParam(name = "userId") Long id){

        List<Challenge> list = challengeService.getChallengesByUserId(id);

        return list;

    }


    @PostMapping
    public String addChallenge(@RequestBody ChallengeDto challengeDto, Principal principal){
        Challenge result;
        if(principal == null){
            return "로그인 해주세여";
        }
        else {
            String isbn = challengeDto.getIsbn();
//            Book book = bookService.getBookByIsbn(isbn);

            String email = principal.getName();
            User user = userService.getUserByEmail(email);
            Challenge challenge = new Challenge();
            challenge.setUser(user);
            BeanUtils.copyProperties(challengeDto, challenge);
            System.out.println(challengeDto.toString());

            result = challengeService.addChallenge(challenge);
        }
        if(result.getBooksTitle() != null) {
            return "도전등록완료!";
        }else {
            return "실패!";
        }
    }
}
