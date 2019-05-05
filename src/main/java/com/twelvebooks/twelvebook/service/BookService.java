package com.twelvebooks.twelvebook.service;

import com.twelvebooks.twelvebook.domain.Book;

import java.util.List;

public interface BookService {

    Book getBookByIsbn(String isbn);
}
