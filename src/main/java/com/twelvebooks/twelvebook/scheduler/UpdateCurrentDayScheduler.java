package com.twelvebooks.twelvebook.scheduler;

import com.twelvebooks.twelvebook.repository.DiaryRepository;
import com.twelvebooks.twelvebook.service.ChallengeService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

@Component // 1
@Slf4j
public class UpdateCurrentDayScheduler {
    //TODO Bean으로 등록
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    String date = dateFormat.format(new Date());

    Date date1;

    {
        try {
            //SimpleDateFormat사용해서 yyyy-MM-dd 포멧으로 변경
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    ChallengeService challengeService;

    //매일 24시에 실행되는 스케쥴러
    //TODO 24시에 update되는 중에 유저가 Challenge를 등록하거나 삭제 했을때 처리는 어떻게 해야하나.
    @Scheduled(cron = "0 0 0 * * *")
    public void updateChallengeDays() {
        //상태가 '읽는중'인 Challenge들의 일차를 1일씩 올려주고
        challengeService.updateAllCurrentDays(date1, "읽는중");
        //상태를 변경해주기 위한 코드
        challengeService.updateBookStatus();

        log.info("updated at : {}", dateFormat.format(new Date()));
    }

}

