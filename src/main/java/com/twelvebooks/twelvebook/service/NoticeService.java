package com.twelvebooks.twelvebook.service;


import com.twelvebooks.twelvebook.domain.Notice;
import com.twelvebooks.twelvebook.domain.User;

import java.util.List;

public interface NoticeService {


    public Notice noticeWrite(Notice notice);

    public Notice noticeModify(Notice notice);

    public Notice noticeDelete(Notice notice);

//    public List<Notice> noticeList(int page, String search);
//    public List<Notice> noticeList(int page);

    public List<Notice> noticeList();

    public Notice noticeDetail(Long id);



}


