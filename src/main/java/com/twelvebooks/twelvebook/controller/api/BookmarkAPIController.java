package com.twelvebooks.twelvebook.controller.api;


import com.twelvebooks.twelvebook.controller.BookmarkController;
import com.twelvebooks.twelvebook.domain.Book;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("/api/bookmark")
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

    @GetMapping("/delete/{id}")
    public int bookmarkDelete(@PathVariable(name="id") Long id, Principal principal) {
        User user =  userService.getUserByEmail(principal.getName());
        bookmarkRepository.deleteById(id);
        return bookmarkService.bookmarkList(user.getId()).size();

    }


    @DeleteMapping(value = "/{id}")
    public int delete(@PathVariable(value = "id") Long id, Principal principal){
        User user =  userService.getUserByEmail(principal.getName());
        bookmarkService.bookmarkDelete(id);

        return bookmarkService.bookmarkList(user.getId()).size();

    }

//    @DeleteMapping(value = "/{listId}")
//    public int delete(@PathVariable(value = "listId") Long id, Principal principal){
//        User user = userService.getUserByEmail(principal.getName());
//        bookmarkService.bookmarkDelete(id);
//        return bookmarkService.selectAllByUserId(user.getId()).size();
//    }


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
        return "challenges/addform";
    }


}
