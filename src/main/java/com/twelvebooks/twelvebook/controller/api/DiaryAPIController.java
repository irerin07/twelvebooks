package com.twelvebooks.twelvebook.controller.api;

import com.twelvebooks.twelvebook.domain.Diary;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/diaries")
public class DiaryAPIController {

    @GetMapping
    public List<Diary> getDiariesByChallengeId(
            @RequestParam(name = "challengeId") long id
    ){


        return null;
    }
}
