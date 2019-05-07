package com.twelvebooks.twelvebook.service;

import com.twelvebooks.twelvebook.domain.Book;

import java.util.List;

public interface BookService {

    public Book getBookByIsbn(String isbn);

    public Book addBook(Book book);

    public Book ckeckBook(String isbn);

}
