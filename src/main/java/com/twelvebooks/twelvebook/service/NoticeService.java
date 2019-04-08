package com.twelvebooks.twelvebook.service;


import com.twelvebooks.twelvebook.domain.Notice;
import com.twelvebooks.twelvebook.domain.User;

import java.util.List;

public interface NoticeService {


    public Notice noticeWrite(Notice notice);
    public List<Notice> noticeList(int page, String searchKind, String searchStr);
    public Notice noticeDetail(Long id);



}


