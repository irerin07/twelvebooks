package com.twelvebooks.twelvebook.controller;


import com.twelvebooks.twelvebook.domain.Notice;
import com.twelvebooks.twelvebook.repository.NoticeRepository;
import com.twelvebooks.twelvebook.security.SecurityUser;
import com.twelvebooks.twelvebook.service.ImageFileService;
import com.twelvebooks.twelvebook.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
@RequestMapping("/notices")
@RequiredArgsConstructor
public class NoticeController {

//    @Autowired
//    private ImageFileService imageFileService;

    @Autowired
    private NoticeRepository noticeRepository;

    @Autowired
    private NoticeService noticeService;

    @GetMapping("/list")
    public String noticeList(Model model){

//            @RequestParam(name = "page", required = false, defaultValue = "1") int page
//            ,
//            @RequestParam(name = "searchStr", required = false) String search,
//        List<Notice> notices = noticeService.noticeList(page, search);

        List<Notice> notices = noticeService.noticeList();
        model.addAttribute("notices", notices);
        return "notices/list";
    }

    @GetMapping("/{id}")
    public String noticeDetail(@PathVariable(name="id")Long id,
                               Model model){
        Notice notice = noticeService.noticeDetail(id);
        model.addAttribute("notice", notice);
        return "notices/detail";
    }


    @GetMapping("/write")
    public String noticeWrite(
        @RequestParam(required=false, name = "title") String title,
        @RequestParam(required=false, name = "content") String content
//        @RequestParam(name = "image") MultipartFile[] images
        ){


             Notice notice = new Notice();
             notice.setContent(content);
             notice.setTitle(title);

             // 이미지 추가

             noticeService.noticeWrite(notice);
        return "redirect:/list";
    }

}
