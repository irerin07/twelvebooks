package com.twelvebooks.twelvebook.aop;

import com.twelvebooks.twelvebook.repository.DiaryRepository;
import com.twelvebooks.twelvebook.service.ChallengeService;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component // 1
@Aspect // 2
public class UpdateCurrentDayAspect {
    private static final Logger logger = LoggerFactory.getLogger(RequestLoggingAspect.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    DiaryRepository diaryRepository;
    @Autowired
    ChallengeService challengeService;

    @Scheduled(cron = "0 0 0 * * *")
    public void updateChallengeDays() {
        challengeService.updateAllCurrentDays();
        logger.info("updated! at : {}", dateFormat.format(new Date()));
    }

}

