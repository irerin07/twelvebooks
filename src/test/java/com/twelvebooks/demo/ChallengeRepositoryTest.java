package com.twelvebooks.demo;

import com.twelvebooks.demo.domain.Challenge;
import com.twelvebooks.demo.repository.ChallengeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
    public void getItems() throws Exception{
        List<Challenge> challenges = challengeRepository.getChallenges(1L);

        for(Challenge challenge : challenges){
            System.out.println(challenge.getId());
        }
    }
}
