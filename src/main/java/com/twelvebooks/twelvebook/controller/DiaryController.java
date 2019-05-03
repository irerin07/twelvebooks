package com.twelvebooks.twelvebook.controller;

import com.twelvebooks.twelvebook.domain.Challenge;
import com.twelvebooks.twelvebook.domain.Diary;
import com.twelvebooks.twelvebook.service.ChallengeService;
import com.twelvebooks.twelvebook.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/diary")
@RequiredArgsConstructor
public class DiaryController {

    @Autowired
    DiaryService diaryService;

    @Autowired
    ChallengeService challengeService;

    @GetMapping("/{id}")
    public String diaryList(@PathVariable(name = "id") Long id,
                                Model model) {
        List<Diary> diary = diaryService.getDiariesByChallengeId(id);
        Challenge challenge = challengeService.getChallengeDetail(id);

        model.addAttribute("challenge", challenge);
        model.addAttribute("diary", diary);
        return "diary/view";
    }


}
