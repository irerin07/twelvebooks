package com.twelvebooks.twelvebook.service.implementation;

import com.twelvebooks.twelvebook.domain.Book;
import com.twelvebooks.twelvebook.repository.BookRepository;
import com.twelvebooks.twelvebook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;


    @Override
    public Book getBookByIsbn(String isbn) {

        Optional<Book> book = Optional.ofNullable(bookRepository.getBookByIsbn(isbn));

        return book.get();
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

}
