package com.twelvebooks.twelvebook.controller;


import com.twelvebooks.twelvebook.service.ImageFileService;
import com.twelvebooks.twelvebook.service.NoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notices")
public class NoticeController {

    private NoticeService noticeService;
    private ImageFileService imageFileService;


}
