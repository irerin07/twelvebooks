package com.twelvebooks.twelvebook.service.implementation;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twelvebooks.twelvebook.Util.Utils;
import com.twelvebooks.twelvebook.service.KakaoBookApiService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class KakaoBookApiServiceImpl implements KakaoBookApiService {
    private static final String API_REST_API_KEY = "dc0d381e1832f6eaeeb3659950e4d2ac";
    private static final String API_BOOK_URL = "https://dapi.kakao.com/v3/search/book";

    @Override
    public Map<String, Object> searchBooks(String searchWord, String target, String category, int page) {
        final String URL = API_BOOK_URL + "?target=" + target +  "&category=" + category + "&page="
                + page;
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "KakaoAK " + API_REST_API_KEY);
        Map<String, String> params = new HashMap<>();
        params.put("query", searchWord);
        String jsonString = null;
        Map<String, Object> resultData = null;
        try {
            jsonString = Utils.getHttpPOST2String(URL, headers, params);
            ObjectMapper mapper = new ObjectMapper();
            resultData = mapper.readValue(jsonString, new TypeReference<Map<String, Object>>() {
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultData;
    }
}
