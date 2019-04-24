package com.twelvebooks.twelvebook.controller.api;

import com.twelvebooks.twelvebook.domain.Notice;
import com.twelvebooks.twelvebook.repository.NoticeRepository;
import com.twelvebooks.twelvebook.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/notices")
@RequiredArgsConstructor
public class NoticeApiController {


//    @Autowired
//    private ImageFileService imageFileService;

    @Autowired
    private NoticeRepository noticeRepository;

    @Autowired
    private NoticeService noticeService;

//    @GetMapping("/list")
//    public String noticeList(Model model){
//        List<Notice> notices = noticeService.noticeList();
//        model.addAttribute("notices", notices);
//        return "notices/list";
//    }

//    @GetMapping("/list")
//    public String noticeList(Model model, @PageableDefault(sort = { "id" }, direction = Sort.Direction.DESC,size = 10 ) Pageable pageable){
//
//        Page<Notice> noticePage = noticeRepository.findAll(pageable);
//        model.addAttribute("noticepage", noticePage);
//        return "notices/list";
//    }
//
//    @GetMapping("/{id}")
//    public String noticeDetail(@PathVariable(name="id")Long id,
//                               Model model){
//        Notice notice = noticeService.noticeDetail(id);
//        model.addAttribute("notice", notice);
//        return "notices/detail";
//    }
//
//
//    @GetMapping("/write")
//    public String writeForm(Model model){
//        return "notices/write";
//    }
//
//    @PostMapping("/write")
//    public String noticeWrite(
//            @RequestParam(name = "title") String title,
//            @RequestParam(name = "content") String content
////        @RequestParam(name = "image") MultipartFile[] images
//    ){
//
//
//        Notice notice = new Notice();
//        notice.setContent(content);
//        notice.setTitle(title);
//
//        // 이미지 추가
//
//        noticeService.noticeWrite(notice);
//        return "redirect:/notices/list";
//    }
//
//    @GetMapping("/modify/{id}")
//    public String modifyForm(@PathVariable(name="id")Long id,
//                             Model model){
//
//        Notice notice = noticeService.noticeDetail(id);
//        model.addAttribute("notice", notice);
//        return "notices/modify";
//    }
//
//    @PostMapping("/modify/{id}")
//    public String noticeModify(
//            @RequestParam(name = "title") String title,
//            @RequestParam(name = "content") String content,
//            @PathVariable(name="id")Long id,
//            Notice notice
////        @RequestParam(name = "image") MultipartFile[] images
//    ){
//        notice.setContent(content);
//        notice.setTitle(title);
//
//        // 이미지 추가
//
//        noticeService.noticeModify(notice, id);
//        return "redirect:/notices/list";
//    }
//
//
//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable(name="id") Long id){
//        noticeRepository.deleteById(id);
//        return "redirect:/notices/list";
//    }
//

}
