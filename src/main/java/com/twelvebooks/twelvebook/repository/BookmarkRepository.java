package com.twelvebooks.twelvebook.repository;


import com.twelvebooks.twelvebook.domain.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

    //user id 에 해당하는 bookmark list를 가져온다.
    @Query("SELECT b FROM Bookmark b WHERE b.id = :id")
    public List<Bookmark> getBookmark(@Param("id") Long id);

}
