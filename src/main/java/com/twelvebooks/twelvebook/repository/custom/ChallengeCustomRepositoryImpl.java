package com.twelvebooks.twelvebook.repository.custom;

import com.twelvebooks.twelvebook.domain.Challenge;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;
//TODO Library페이지 Pagination 관련
public class ChallengeCustomRepositoryImpl implements ChallengeCustomRepository {

    @Override
    public List<Challenge> getChallegesByUserId(Long id, int start, int limit) {

        return null;
    }
}
