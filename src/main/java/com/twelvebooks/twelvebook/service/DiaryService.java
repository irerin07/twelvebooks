package com.twelvebooks.twelvebook.service;

import com.twelvebooks.twelvebook.domain.Diary;

import java.util.List;

public interface DiaryService {
    //다이어리 등록
    public Diary addDiary(Diary diary);

    //챌린지에 따른 다이어리들 가져오기
    public List<Diary> getDiariesByChallengeId(long challengeIdd);

}
