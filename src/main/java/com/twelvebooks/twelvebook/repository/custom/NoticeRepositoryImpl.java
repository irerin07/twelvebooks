package com.twelvebooks.twelvebook.repository.custom;

import com.twelvebooks.twelvebook.domain.Notice;
import com.twelvebooks.twelvebook.repository.NoticeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class NoticeRepositoryImpl implements NoticeRepository {


    @Override
    public List<Notice> getNotices(int start, int limit, String searchKind, String searchStr) {
        return null;
    }

    @Override
    public Notice getNotice(Long id) {
        return null;
    }
}
