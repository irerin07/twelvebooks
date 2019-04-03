package com.twelvebooks.twelvebook.service;

import com.twelvebooks.twelvebook.domain.Challenge;

import java.util.List;

public interface ChallengeService {
    public Challenge addChallenge(Challenge challlenge);
    public List<Challenge> getChallengesByUserId(long id);

}
