package com.twelvebooks.twelvebook.service.implementation;

import com.twelvebooks.twelvebook.domain.Notice;
import com.twelvebooks.twelvebook.repository.NoticeRepository;
import com.twelvebooks.twelvebook.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeRepository noticeRepository;

//    public final static String TITLE_OR_CONTENT_SEARCH = "title_content_search";


    @Override
    public Notice noticeWrite(Notice notice) {
        return noticeRepository.save(notice);
    }

//    @Override
//    @Transactional
//    public List<Notice> noticeList(int page, String search) {
//        int limit = 10;
//        int start = page * limit - limit;
//        return noticeRepository.getNotices(start, limit, search);
//        return noticeRepository.getNotices(start, limit, search);
//
//    }

    @Override
    public List<Notice> noticeList() {
//        int limit = 10;
//        int start = page * limit - limit;
//        return noticeRepository.getNotices(start,limit);
        List<Notice> notices= null;
        notices =  noticeRepository.getNotices();
        return notices;
    }

    @Override
    public Notice noticeDetail(Long id) {
        return noticeRepository.getNotice(id);
    }

    @Override
    public Notice noticeModify(Notice notice) {
        return noticeRepository.save(notice);}


//    @Override
//    public Notice noticeDelete(Notice notice) {
////        return noticeRepository.delete(notice.getId());
//    return null;
//
//    }
}
