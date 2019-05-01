package com.twelvebooks.twelvebook.service.implementation;

import com.twelvebooks.twelvebook.domain.Bookmark;
import com.twelvebooks.twelvebook.repository.BookmarkRepository;
import com.twelvebooks.twelvebook.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class BookmarkServiceImpl implements BookmarkService {


    @Autowired
    BookmarkRepository bookmarkRepository;

    @Override
    public List<Bookmark> bookmarkList(Long id) {

        List<Bookmark> bookmarks  = bookmarkRepository.getBookmarks(id);
        return bookmarks;
//        return bookmarks;
    }

    @Override
    @Transactional
    public Bookmark bookmarkAdd(Bookmark bookmark) {
        return bookmarkRepository.save(bookmark);
    }


    @Override
    @Transactional
    public void bookmarkDelete(Long id) {
        bookmarkRepository.deleteById(id);
    }

//    @Override
//    @Transactional(readOnly = true)
//    public List<Bookmark> selectAllByUserId(Long userId) {
//        return bookmarkRepository.findAllByUserId(userId);
//    }
}
