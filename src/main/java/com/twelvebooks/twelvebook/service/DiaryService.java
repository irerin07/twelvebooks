package com.twelvebooks.twelvebook.service;

import com.twelvebooks.twelvebook.domain.Diary;

import java.util.List;

public interface DiaryService {
    public Diary addDiary();
    public List<Diary>  getDiariesByChallengeId();

}
