package com.twelvebooks.twelvebook.service;


import com.twelvebooks.twelvebook.domain.Notice;
import com.twelvebooks.twelvebook.domain.User;

import java.util.List;

public interface NoticeService {


    public Notice noticeWrite(Notice notice);

    public Notice noticeModify(Notice notice, Long id);

    public List<Notice> noticeList();

    public Notice noticeDetail(Long id);



}


