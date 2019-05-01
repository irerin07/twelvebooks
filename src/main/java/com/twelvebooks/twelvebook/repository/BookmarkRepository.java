package com.twelvebooks.twelvebook.repository;


import com.twelvebooks.twelvebook.domain.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

    //user id 에 해당하는 bookmark list를 가져온다.
    @Query("SELECT b FROM Bookmark b WHERE b.user.id = :id ORDER BY b.id DESC")
    public List<Bookmark> getBookmarks(@Param("id") Long id);

//    @Query("SELECT b FROM Bookmark b WHERE b.user.id = ?1 ORDER BY b.id DESC")
//    public List<Bookmark> findAllByUserId(Long UserId);

}
