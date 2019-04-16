package com.twelvebooks.twelvebook.service;

import com.twelvebooks.twelvebook.domain.Book;

import java.util.List;

public interface BookService {
    public List<Book> getAllBooksByUser();
}
