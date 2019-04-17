package com.twelvebooks.twelvebook.repository;

import com.twelvebooks.twelvebook.domain.Book;
import com.twelvebooks.twelvebook.domain.Challenge;
import com.twelvebooks.twelvebook.repository.ChallengeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChallengeRepositoryTest {
    @Autowired
    ChallengeRepository challengeRepository;

    @Test
    public void contextLoads(){

    }

    @Test
    public void getChallengesById() throws Exception{
        List<Challenge> challenges = challengeRepository.getChallenges(1L);
        for(Challenge challenge : challenges){
            System.out.println(challenge.getBooksTitle());
        }
    }

}
