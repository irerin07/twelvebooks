package com.twelvebooks.twelvebook.service.implementation;

import com.twelvebooks.twelvebook.domain.Bookmark;
import com.twelvebooks.twelvebook.repository.BookmarkRepository;
import com.twelvebooks.twelvebook.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookmarkServiceImpl implements BookmarkService {


    @Autowired
    BookmarkRepository bookmarkRepository;

    @Override
    public List<Bookmark> bookmarkList(Long id) {

        List<Bookmark> bookmarks = null;
        bookmarks = bookmarkRepository.getBookmark(id);
        return bookmarks;
    }

    @Override
    public Bookmark bookmarkAdd(Bookmark bookmark) {
        return bookmarkRepository.save(bookmark);
    }
}
