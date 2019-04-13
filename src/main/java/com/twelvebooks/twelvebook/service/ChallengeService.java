package com.twelvebooks.twelvebook.service;

import com.twelvebooks.twelvebook.domain.Challenge;

import java.util.List;

public interface ChallengeService {

    //user의 도전 목록 가져오는 메소드
    public List<Challenge> getChallengesByUserId(long id);

    //admin에서 전체 도전 목록을 가져오는 메소드
    public List<Challenge> getChallengesAll();

    //새로운 도전
//    public Challenge addChallenge(Challenge challenge);

}
