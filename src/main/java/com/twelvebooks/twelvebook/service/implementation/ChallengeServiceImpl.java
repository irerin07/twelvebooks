package com.twelvebooks.twelvebook.service.implementation;

import com.twelvebooks.twelvebook.domain.Book;
import com.twelvebooks.twelvebook.domain.Challenge;
import com.twelvebooks.twelvebook.repository.ChallengeRepository;
import com.twelvebooks.twelvebook.service.BookService;
import com.twelvebooks.twelvebook.service.ChallengeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChallengeServiceImpl implements ChallengeService {
    @Autowired
    private ChallengeRepository challengeRepository;

//    @Autowired
//    private BookService bookService;

    @Override
    @Transactional
    public Challenge addChallenge(Challenge challenge) {
//        Book book = new Book();
//        book.setTitle(challenge.getBooksTitle());
//        book.setIsbn(challenge.getIsbn());
//        book.setThumbnailImage(challenge.getThumbnailImage());

        Challenge addChallenge =  challengeRepository.save(challenge);

        return addChallenge;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Challenge> getChallengesByUserId(long id) {
        List<Challenge> challenges = null;
        challenges = challengeRepository.getChallenges(id);
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

    @Override
    public List<Challenge> getChallengesByUserIdStatus(long id, String status) {
        List<Challenge> list = null;
        list = challengeRepository.getChallengesByStatus(id, status);
        return list;
    }

    @Override
    @Transactional
    public void updateAllCurrentDays(Date date1, String status) {
        challengeRepository.updateAllCurrentDays(date1, status);
    }

    @Override
    @Transactional
    public void updateBookStatus() {
        challengeRepository.updateBookStatus();
    }
}
