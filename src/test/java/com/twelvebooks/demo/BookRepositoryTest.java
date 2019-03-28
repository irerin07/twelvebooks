package com.twelvebooks.demo;

import com.twelvebooks.demo.domain.Book;
import com.twelvebooks.demo.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookRepositoryTest {
    @Autowired
    BookRepository bookRepository;

    @Test
    public void getBooks() throws Exception{
        List<Book> books = bookRepository.getBooks(0,3, "searchKind", "searchStr");

        for(Book book : books){
            System.out.println(book.getTitle());
        }
    }
}
