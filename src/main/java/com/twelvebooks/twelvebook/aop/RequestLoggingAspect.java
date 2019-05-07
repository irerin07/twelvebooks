package com.twelvebooks.twelvebook.aop;

import com.google.common.base.Joiner;
import com.twelvebooks.twelvebook.repository.ChallengeRepository;
import com.twelvebooks.twelvebook.repository.DiaryRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

@Component // 1
@Aspect // 2
public class RequestLoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(RequestLoggingAspect.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private static final SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    DiaryRepository diaryRepository;
    @Autowired
    ChallengeRepository challengeRepository;

//    @Scheduled(cron = "0 0 0 * * *")
//    public void updateChallengeDays() {
//
//    }

//    @Scheduled(cron = "30 * * * * *")
//    public void reportCurrentTime() {
//        logger.info("The time is now {}", dateFormat.format(new Date()));
//    }

    private String paramMapToString(Map<String, String[]> paramMap) {
        return paramMap.entrySet().stream()
                .map(entry -> String.format("%s -> (%s)",
                        entry.getKey(), Joiner.on(",").join(entry.getValue())))
                .collect(Collectors.joining(", "));
    }

    @Pointcut("within(com.twelvebooks.twelvebook.controller.api..*)") // 3
    public void onRequest() {}

    @After("execution(* com.twelvebooks.twelvebook.controller.api.*.*(..))") // 4
    public Object doLogging(JoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = // 5
                ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        Map<String, String[]> paramMap = request.getParameterMap();
        String params = "";
        if (paramMap.isEmpty() == false) {
            params = " [" + paramMapToString(paramMap) + "]";
        }

        long start = System.currentTimeMillis();
        try {
            return joinPoint.getArgs();
//            return pjp.proceed(pjp.getArgs()); // 6
        } finally {
            long end = System.currentTimeMillis();
            logger.info("Request: {} {}{} < {} ({}ms)", request.getMethod(), request.getRequestURI(),
                    params, request.getRemoteHost(), end - start);
        }
    }
}

