package com.twelvebooks.twelvebook.controller.api;

import com.twelvebooks.twelvebook.domain.Diary;
import com.twelvebooks.twelvebook.dto.DiaryDto;
import com.twelvebooks.twelvebook.repository.DiaryRepository;
import com.twelvebooks.twelvebook.service.ChallengeService;
import com.twelvebooks.twelvebook.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/diaries")
public class DiaryAPIController {

    @Autowired
    DiaryService diaryService;
    @Autowired
    ChallengeService challengeService;

    @PostMapping
    public Diary postReview(@RequestBody DiaryDto diaryDto){
        return diaryService.addDiary(diaryDto);

//        System.out.println("DiaryDto: " + diaryDto.getContent());
//        System.out.println("DiaryDto: " + diaryDto.getChalid());
//        System.out.println("DiaryDto: " + diaryDto.getDays());
//        Diary diary = new Diary();
//        diary.setContent(diaryDto.getContent());
//        diary.setDays(diaryDto.getDays());
//        diary.setChallenge(challengeService.getChallengeDetail(diaryDto.getChalid()));
//        diaryService.addDiary(diary);

    }

    @GetMapping
    public List<Diary> getDiariesByChallengeId(
            @RequestParam(name = "challengeId") long id
    ){


        return null;
    }
}
