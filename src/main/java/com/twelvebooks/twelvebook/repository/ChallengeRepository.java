package com.twelvebooks.twelvebook.repository;

import com.twelvebooks.twelvebook.domain.Challenge;
import com.twelvebooks.twelvebook.repository.custom.ChallengeCustomRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ChallengeRepository extends JpaRepository<Challenge, Long>, ChallengeCustomRepository {
    //1.User에 해당하는 List<Challenge>가져오는 쿼리

//    @Query(value = "SELECT c FROM Challenge c INNER JOIN FETCH c.user WHERE c.user.id = :id AND c.bookStatus = :status ORDER BY c.id DESC",
//            countQuery = "SELECT count(c) FROM Challenge c")
//    public List<Challenge> getChallenges(@Param("id") Long id, @Param("status") String status);

    @Query(value = "SELECT c FROM Challenge c INNER JOIN FETCH c.user WHERE c.user.id = :id ORDER BY c.id DESC",
            countQuery = "SELECT count(c) FROM Challenge c")
    public List<Challenge> getChallenges(@Param("id") Long id);

    // 2.User에 해당하는 Challenge의 정보를 가져오는 쿼리
    @Query("SELECT c FROM Challenge c WHERE c.id = :id ORDER BY c.id DESC")
    public Challenge getChallengeDetail(@Param("id") Long id);

    //BookStatus(읽는중, 완료)에 따라 도전목록을 가져오는 쿼리
    @Query("SELECT c FROM Challenge c INNER JOIN FETCH c.user WHERE c.user.id =:id AND c.bookStatus =:status ORDER BY c.id DESC")
    public List<Challenge> getChallengesByStatus(@Param("id") long id,
                                                 @Param("status") String status);

    //오늘 날짜가 (24시 정각 기준) 도전 시작한 날보다 이후의 날이면 도전일수를 1 증가
    @Modifying
    @Query("UPDATE Challenge c SET c.currentDay = currentDay+1 WHERE c.startDate <= :date1 AND c.bookStatus = :status")
    public int updateAllCurrentDays(@Param("date1") Date date1,
                                    @Param("status")String status);

    //24시 정각 기준으로 도전일수가 오늘의 일차수보다 작다면 도전의 상태를 완료로 변경
    @Modifying
    @Query("UPDATE Challenge  c SET c.bookStatus = '완료' WHERE c.days < c.currentDay")
    public void updateBookStatus();

    //TODO Library페이지 Pagination 관련
    @Query(value = "SELECT c FROM Challenge c INNER JOIN FETCH c.user WHERE c.user.id = :id ORDER BY c.id DESC",
            countQuery = "SELECT count(c) FROM Challenge c")
    public Page<Challenge> getChallegesByUserId(@Param("id") long id,
                                    Pageable pageable);
}
