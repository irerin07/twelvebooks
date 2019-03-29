package com.twelvebooks.demo.service;

import com.twelvebooks.demo.domain.Diary;

import java.util.List;

public interface DiaryService {
    public Diary addDiary();
    public List<Diary>  getDiariesByChallengeId();

}
