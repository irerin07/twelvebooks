package com.twelvebooks.twelvebook.service.implementation;

import com.twelvebooks.twelvebook.domain.Challenge;
import com.twelvebooks.twelvebook.repository.ChallengeRepository;
import com.twelvebooks.twelvebook.service.ChallengeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChallengeServiceImpl implements ChallengeService {
    @Autowired
    private ChallengeRepository challengeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Challenge> getChallengesByUserId(long id, String status) {
        List<Challenge> challenges = null;
        challenges = challengeRepository.getChallenges(id, status);
        return challenges;
    }

    @Override
    public List<Challenge> getChallengesAll() {
        List<Challenge> challenges = new ArrayList<>();
        challenges = challengeRepository.findAll();
        return challenges;
    }

    @Override
    public Challenge getChallengeDetail(long id) {
        Challenge challenge = null;
        challenge = challengeRepository.getChallengeDetail(id);
        return challenge;
    }
}
