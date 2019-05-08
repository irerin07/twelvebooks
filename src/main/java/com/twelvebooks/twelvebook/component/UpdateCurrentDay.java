package com.twelvebooks.twelvebook.component;

import com.twelvebooks.twelvebook.aop.RequestLoggingAspect;
import com.twelvebooks.twelvebook.repository.DiaryRepository;
import com.twelvebooks.twelvebook.service.ChallengeService;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component // 1
public class UpdateCurrentDay {
    private static final Logger logger = LoggerFactory.getLogger(RequestLoggingAspect.class);
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
    DiaryRepository diaryRepository;
    @Autowired
    ChallengeService challengeService;

    //매일 24시에 실행되는 스케쥴러
    @Scheduled(cron = "0 0 0 * * *")
    public void updateChallengeDays() {
        //상태가 '읽는중'인 Challenge들의 일차를 1일씩 올려주고
        challengeService.updateAllCurrentDays(date1, "읽는중");
        //상태를 변경해주기 위한 코드
        challengeService.updateBookStatus();

        logger.info("updated at : {}", dateFormat.format(new Date()));
    }

}

