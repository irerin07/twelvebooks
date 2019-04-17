package com.twelvebooks.twelvebook.service;


import com.twelvebooks.twelvebook.domain.Bookmark;

import java.util.List;

public interface BookmarkService {


    public List<Bookmark> bookmarkList(Long id);

    public Bookmark bookmarkAdd(Bookmark bookmark);
}
