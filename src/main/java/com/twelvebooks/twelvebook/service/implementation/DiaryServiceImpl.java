package com.twelvebooks.twelvebook.service.implementation;

import com.twelvebooks.twelvebook.domain.Diary;
import com.twelvebooks.twelvebook.service.DiaryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaryServiceImpl implements DiaryService {

    @Override
    public Diary addDiary(Diary diary) {
        return null;
    }

    @Override
    public List<Diary> getDiariesByChallengeId(long ChallengeId) {
        return null;
    }
}
