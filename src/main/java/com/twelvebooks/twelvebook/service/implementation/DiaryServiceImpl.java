package com.twelvebooks.twelvebook.service.implementation;

import com.twelvebooks.twelvebook.domain.Challenge;
import com.twelvebooks.twelvebook.domain.Diary;
import com.twelvebooks.twelvebook.dto.DiaryDto;
import com.twelvebooks.twelvebook.repository.ChallengeRepository;
import com.twelvebooks.twelvebook.repository.DiaryRepository;
import com.twelvebooks.twelvebook.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiaryServiceImpl implements DiaryService {

    @Autowired
    DiaryRepository diaryRepository;
    @Autowired
    ChallengeRepository challengeRepository;

    @Override
    @Transactional
    public Diary addDiary(DiaryDto diarydto) {
        long chalId = diarydto.getChalid();

        Challenge challenge = challengeRepository.getChallengeDetail(chalId);

        Diary diary = new Diary();

        diary.setContent(diarydto.getContent());
        diary.setDays(diarydto.getDays());
        diary.setChallenge(challenge);

        Diary save = diaryRepository.save(diary);

        return save;
    }

    @Override
    public List<Diary> getDiariesByChallengeId(long ChallengeId) {

        return null;
    }
}
