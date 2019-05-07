package com.twelvebooks.twelvebook.service.implementation;

import com.twelvebooks.twelvebook.domain.Book;
import com.twelvebooks.twelvebook.repository.BookRepository;
import com.twelvebooks.twelvebook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Override
    public Book getBookByIsbn(String isbn) {

        Book book = bookRepository.getBookByIsbn(isbn);

        return book;
    }

    @Override
    public Book addBook(Book book) {

        Book result =  bookRepository.save(book);

        return result;
    }
}
