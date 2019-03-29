package com.twelvebooks.demo.service;

import com.twelvebooks.demo.domain.Challenge;

import java.util.List;

public interface ChallengeService {
    public Challenge addChallenge();
    public List<Challenge> getChallengesByUserId(long id);

}
