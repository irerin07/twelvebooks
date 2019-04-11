package com.twelvebooks.twelvebook.repository;

import com.twelvebooks.twelvebook.domain.Notice;
import com.twelvebooks.twelvebook.repository.custom.NoticeRepositoyCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice, Long>, NoticeRepositoyCustom {

    @Query(value = "SELECT n FROM Notice n ORDER BY n.id DESC", countQuery = "SELECT count(n) FROM Notice n")
    public Page<Notice> getNoticesPage(Pageable pageable);


//    @Query(value = "SELECT n FROM Notice n ORDER BY n.id DESC")
//    public List<Notice> getNotices(int start, int limit);

    @Query(value = "SELECT n FROM Notice n ORDER BY n.id DESC")
    public List<Notice> getNotices();

    @Query("SELECT distinct n FROM Notice n LEFT JOIN FETCH n.imageFiles WHERE n.id = :id")
    public Notice getNotice(@Param("id") Long id);
}
