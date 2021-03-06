package com.twelvebooks.twelvebook.service;

import com.twelvebooks.twelvebook.domain.Challenge;

import java.util.Date;
import java.util.List;

public interface ChallengeService {

    //user의 도전을 추가하는 메소드
    public Challenge addChallenge(Challenge challenge);

    //user의 도전 목록 가져오는 메소드
    public List<Challenge> getChallengesByUserId(long id);

    //admin에서 전체 도전 목록을 가져오는 메소드
    public List<Challenge> getChallengesAll();

    //새로운 도전
//    public Challenge addChallenge(Challenge challenge);

    public Challenge getChallengeDetail(long id);

    List<Challenge> getChallengesByUserIdStatus(long id, String status);

    public void updateAllCurrentDays(Date date1, String status);

    public void updateBookStatus();

    //TODO Library페이지 Pagination 관련
    public List<Challenge> getChallegesByUserId(long id, int page);
}
