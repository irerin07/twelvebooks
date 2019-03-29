package com.twelvebooks.demo.repository;

import com.twelvebooks.demo.domain.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
    //1.Challenge에 해당하는 다이어리 가져오기
    @Query(value = "SELECT d FROM Diary d INNER JOIN FETCH d.challenge WHERE d.challenge.id = :id")
    public List<Diary> getDiariesByChallengeId(@Param("id") long id);

    //2.User에 해당하는 다이어리 가져오기
    @Query(value = "SELECT d FROM Diary d " +
                    "INNER JOIN FETCH d.challenge c " +
                    "INNER JOIN FETCH c.user u " +
                    "WHERE u.id = :id")
    public List<Diary> getDiariesByCIdAndUid(@Param("id") long id);
}
