package com.twelvebooks.twelvebook.aop;

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
@Aspect // 2
public class UpdateCurrentDayAspect {
    private static final Logger logger = LoggerFactory.getLogger(RequestLoggingAspect.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    String date = dateFormat.format(new Date());

    Date date1;

    {
        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            System.out.println(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    @Autowired
    DiaryRepository diaryRepository;
    @Autowired
    ChallengeService challengeService;

    @Scheduled(cron = "0 0 0 * * *")
    public void updateChallengeDays() {
        challengeService.updateAllCurrentDays(date1);
        logger.info("updated at : {}", dateFormat.format(new Date()));
    }

}

