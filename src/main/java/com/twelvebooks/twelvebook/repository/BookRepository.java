package com.twelvebooks.twelvebook.repository;

import com.twelvebooks.twelvebook.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    //List<Book>전부 가져오기
    @Query(value = "SELECT b FROM Book b ORDER BY b.id DESC",
            countQuery = "SELECT count(b) FROM Book b"
    )
    public List<Book> getBooks( int start, int limit, String searchKind, String searchStr);


    //isbn에 해당하는 Book가져오기
    @Query(value = "SELECT b FROM Book b WHERE b.isbn = :isbn")
    public Book getBookByIsbn(@Param("isbn") String isbn);
}
