package com.twelvebooks.twelvebook.service;

import com.twelvebooks.twelvebook.domain.Book;
import com.twelvebooks.twelvebook.domain.Challenge;
import com.twelvebooks.twelvebook.domain.User;
import com.twelvebooks.twelvebook.repository.ChallengeRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChallengeServiceImpl {
    @MockBean
    User user;
    @MockBean Challenge challenge;
    @MockBean
    Book book;
    @MockBean ChallengeRepository challengeRepository;

    @Before
    public void init(){
//        user.setId(100);
//        user.setPasswd("1234");
//        user.setName("테스트목");
//        user.setComment("감사합니다");
//        user.setEmail("test@gmail.com");



    }
    @Test
    public void addChallenge(){

        challenge.setUser(user);
        challenge.setBook(book);
        challenge.setBooksTitle("test");
        challenge.setBookStatus("읽는중");
        challenge.setVisibility("비공개");

    }

}
