package com.twelvebooks.twelvebook.controller.api;

import com.twelvebooks.twelvebook.domain.Diary;
import com.twelvebooks.twelvebook.dto.DiaryDto;
import com.twelvebooks.twelvebook.repository.DiaryRepository;
import com.twelvebooks.twelvebook.service.ChallengeService;
import com.twelvebooks.twelvebook.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/diaries")
public class DiaryAPIController {

    @Autowired
    DiaryService diaryService;
    @Autowired
    ChallengeService challengeService;

//    @PostMapping
//    public int postReview(@RequestBody DiaryDto diaryDto){
//        return diaryService.addDiary(diaryDto);
//    }

    @PostMapping
    public ResponseEntity postReview(@RequestBody DiaryDto diaryDto){
        int count = diaryService.addDiary(diaryDto);
        ResponseEntity<Integer> responseEntity = new ResponseEntity<>(count,
                HttpStatus.OK);
        return new ResponseEntity<ResponseEntity>(responseEntity , HttpStatus.OK);
    }

    @GetMapping
    public List<Diary> getDiariesByChallengeId(@RequestParam(name = "challengeId") long id){
        return null;
    }
}
