package com.twelvebooks.twelvebook.service.implementation;

import com.twelvebooks.twelvebook.domain.Diary;
import com.twelvebooks.twelvebook.repository.DiaryRepository;
import com.twelvebooks.twelvebook.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaryServiceImpl implements DiaryService {

    @Autowired
    DiaryRepository diaryRepository;

    @Override
    public Diary addDiary(Diary diary) {
        Diary save = diaryRepository.save(diary);
        return save;
    }

    @Override
    public List<Diary> getDiariesByChallengeId(long ChallengeId) {
        return null;
    }
}
