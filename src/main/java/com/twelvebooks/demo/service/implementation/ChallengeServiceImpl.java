package com.twelvebooks.demo.service.implementation;

import com.twelvebooks.demo.domain.Challenge;
import com.twelvebooks.demo.repository.ChallengeRepository;
import com.twelvebooks.demo.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallengeServiceImpl implements ChallengeService {
    @Autowired
    private ChallengeRepository challengeRepository;

    @Override
    public Challenge addChallenge(Challenge challlenge) {
        Challenge challenge = challengeRepository.save(challlenge);
        return challenge;
    }

    @Override
    public List<Challenge> getChallengesByUserId(long id) {
        return null;
    }
}
