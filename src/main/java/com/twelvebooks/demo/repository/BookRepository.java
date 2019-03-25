package com.twelvebooks.demo.repository;

import com.twelvebooks.demo.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value = "SELECT b FROM Book b ORDER BY b.id DESC",
            countQuery = "SELECT count(b) FROM Book b"
    )
    public List<Book> getBooks( int start, int limit, String searchKind, String searchStr);

    @Query(value = "SELECT b FROM Book b WHERE b.id = :id")
    public Book getBookById(@Param("id") Long id);
}
