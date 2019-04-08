package com.twelvebooks.twelvebook.repository.custom;

import com.twelvebooks.twelvebook.domain.Notice;

import java.util.List;

public interface NoticeRepositoyCustom {

    public List<Notice> getNotices(int start, int limit, String searchKind, String searchStr);
}
