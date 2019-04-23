package com.twelvebooks.twelvebook.controller.api;

import com.twelvebooks.twelvebook.domain.Diary;
import com.twelvebooks.twelvebook.dto.DiaryDto;
import com.twelvebooks.twelvebook.repository.DiaryRepository;
import com.twelvebooks.twelvebook.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/diaries")
public class DiaryAPIController {

    @Autowired
    DiaryService diaryService;

    @PostMapping
    public void postReview(@RequestBody DiaryDto diaryDto){
        System.out.println("DiaryDto: " + diaryDto.getContent());
        Diary diary = new Diary();
        diary.setContent(diaryDto.getContent());
        diaryService.addDiary(diary);


    }

    @GetMapping
    public List<Diary> getDiariesByChallengeId(
            @RequestParam(name = "challengeId") long id
    ){


        return null;
    }
}
