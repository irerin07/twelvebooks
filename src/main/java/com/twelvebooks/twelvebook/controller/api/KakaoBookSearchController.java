package com.twelvebooks.twelvebook.controller.api;

import com.twelvebooks.twelvebook.service.KakaoBookApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class KakaoBookSearchController {
    @Autowired
    KakaoBookApiService kakaoBookApiService;

    @RequestMapping(value = "/searchBooks")
    public Map<String, Object> searchBooks(HttpServletRequest req, HttpServletResponse res,
                                           @RequestParam("searchWord") String searchWord,
                                           @RequestParam(name = "target", defaultValue = "all") String target,
                                           @RequestParam(name = "category", defaultValue = "") String category,
                                           @RequestParam(name = "page", defaultValue = "1") int page) {

        Map<String, Object> result = kakaoBookApiService.searchBooks(searchWord, target, category, page);

        return result;
    }

}
