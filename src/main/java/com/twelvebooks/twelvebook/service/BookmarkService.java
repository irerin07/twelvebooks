package com.twelvebooks.twelvebook.service;


import com.twelvebooks.twelvebook.domain.Bookmark;

import java.util.List;

public interface BookmarkService {


    public List<Bookmark> bookmarkList(Long id);

    public Bookmark bookmarkAdd(Bookmark bookmark);

    public void bookmarkDelete(Long id);

//    public List<Bookmark> selectAllByUserId(Long userId);
}
