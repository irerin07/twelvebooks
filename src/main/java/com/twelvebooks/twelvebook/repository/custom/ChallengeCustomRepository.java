package com.twelvebooks.twelvebook.repository.custom;

import com.twelvebooks.twelvebook.domain.Challenge;

import java.util.List;

public interface ChallengeCustomRepository {
    public List<Challenge> getChallegesByUserId(Long id, int start, int limit);
}
