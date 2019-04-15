package com.twelvebooks.twelvebook.service;

import java.util.Map;

public interface KakaoBookApiService {
    //책검색
    public Map<String, Object> searchBooks(String searchWord, String target, String category, int page);
}
