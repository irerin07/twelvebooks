package com.twelvebooks.twelvebook.controller;

import com.twelvebooks.twelvebook.domain.Bookmark;
import com.twelvebooks.twelvebook.domain.User;
import com.twelvebooks.twelvebook.repository.BookmarkRepository;
import com.twelvebooks.twelvebook.service.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/bookamark")
@RequiredArgsConstructor
public class BookmarkController {

    @Autowired
    BookmarkService bookmarkService;

    @Autowired
    BookmarkRepository bookmarkRepository;

//    @Autowired
//    User user;

    @GetMapping("/list/{id}")
    public String bookmarkList(
            @RequestParam(name="id") Long id,
            Model model){
        List<Bookmark> bookmarks = bookmarkService.bookmarkList(id);
        model.addAttribute("bookmarks", bookmarks);

//        user = user.getId();
//        model.addAttribute("user", user);
        return "bookmark/list";
    }

    @GetMapping("/delete/{id}")
    public String bookmarkdelete(@PathVariable(name="id") Long id){
        bookmarkRepository.deleteById(id);
        return "redirect:/bookmark/list";
    }

    @PostMapping("/add")
    public String bookmarkAdd(
            @RequestParam(name = "bookTitle") String bookTitle,
            @RequestParam(name = "isbn") String isbn,
            @RequestParam(name = "thumbnailImage") String thumbnailImage
    ){
        Bookmark bookmark = new Bookmark();
        bookmark.setBookTitle(bookTitle);
        bookmark.setIsbn(isbn);
        bookmark.setThumbnailImage(thumbnailImage);

        bookmarkService.bookmarkAdd(bookmark);
        return "redirect:/challenges/addform";
    }
}
