package com.twelvebooks.twelvebook.controller;

import com.twelvebooks.twelvebook.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/diary")
@RequiredArgsConstructor
public class DiaryController {

    @Autowired
    DiaryService diaryService;

    @GetMapping("/finished")
    public String finishedDiary(){
        return "users/login";
    }


}
