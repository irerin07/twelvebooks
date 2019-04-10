package com.twelvebooks.twelvebook.service.implementation;

import com.twelvebooks.twelvebook.domain.Notice;
import com.twelvebooks.twelvebook.repository.NoticeRepository;
import com.twelvebooks.twelvebook.service.NoticeService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class NoticeServiceImpl implements NoticeService {
    private NoticeRepository noticeRepository;

    public final static String TITLE_SEARCH = "title_search";
    public final static String CONTENT_SEARCH = "content_search";
    public final static String TITLE_OR_CONTENT_SEARCH = "title_content_search";

    @Override
    public Notice noticeWrite(Notice notice) {
        return null;
    }

//    @Override
//    @Transactional
//    public List<Notice> noticeList(int page, String searchKind, String searchStr) {
//        int limit = 10;
//        int start = page * limit - limit;
//        return noticeRepository.getNotices(start, limit, searchKind, searchStr);
//        return noticeRepository.getNotices(start, limit, searchKind, searchStr);
//
//    }


    @Override
    public List<Notice> noticeList(int page) {
//        int limit = 10;
//        int start = page * limit - limit;
//        return noticeRepository.getNotices();
        return null;
    }

    @Override
    public Notice noticeDetail(Long id) {
        return null;
    }
}
