package com.twelvebooks.twelvebook.controller.api;


import com.twelvebooks.twelvebook.domain.Bookmark;
import com.twelvebooks.twelvebook.domain.User;
import com.twelvebooks.twelvebook.repository.BookmarkRepository;
import com.twelvebooks.twelvebook.repository.UserRepository;
import com.twelvebooks.twelvebook.service.BookmarkService;
import com.twelvebooks.twelvebook.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("/api/bookamark")
@RequiredArgsConstructor
public class BookmarkAPIController {

    @Autowired
    BookmarkService bookmarkService;

    @Autowired
    BookmarkRepository bookmarkRepository;

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;


    @GetMapping("/list")
    public String bookmarkList(Model model, Principal principal){

        User user = userService.getUserByEmail(principal.getName());
        List<Bookmark> bookmarks = bookmarkService.bookmarkList(user.getId());
        User username = userService.getUserById(user.getId());

        model.addAttribute("bookmarks", bookmarks);
        model.addAttribute("username", username);
        return "bookmark/list";
    }


    @GetMapping("/delete/{id}")
    public String bookmarkdelete(@PathVariable(name="id") Long id){
        bookmarkRepository.deleteById(id);
        return "redirect:/bookmark/list";
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable(value = "id") Long id){
        bookmarkService.bookmarkDelete(id);
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
