package com.twelvebooks.twelvebook;

import com.twelvebooks.twelvebook.domain.Diary;
import com.twelvebooks.twelvebook.repository.DiaryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiaryRepositoryTest {
    @Autowired
    DiaryRepository diaryRepository;

    @Test
    public void init(){

    }

    @Test
    public void getDiariesByChallengeId(){
        List<Diary> diaryList = diaryRepository.getDiariesByChallengeId(1L);

        for(Diary d : diaryList){
            System.out.println(d.getContent());
        }
    }

}
