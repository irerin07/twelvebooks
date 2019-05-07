package com.twelvebooks.twelvebook.controller.api;


import com.twelvebooks.twelvebook.controller.BookmarkController;
import com.twelvebooks.twelvebook.domain.Book;
import com.twelvebooks.twelvebook.domain.Bookmark;
import com.twelvebooks.twelvebook.domain.User;
import com.twelvebooks.twelvebook.dto.BookDto;
import com.twelvebooks.twelvebook.dto.BookmarkDto;
import com.twelvebooks.twelvebook.repository.BookmarkRepository;
import com.twelvebooks.twelvebook.repository.UserRepository;
import com.twelvebooks.twelvebook.service.BookmarkService;
import com.twelvebooks.twelvebook.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @DeleteMapping(value = "/{bookmarkId}")
    public int delete(@PathVariable(value = "bookmarkId") Long id, Principal principal){
        User user = userService.getUserByEmail(principal.getName());
        bookmarkService.bookmarkDelete(id);
        bookmarkService.bookmarkList(id);

        return bookmarkService.bookmarkList(user.getId()).size();
    }





    @PostMapping("/add")
    public int bookmarkAdd(@RequestBody BookmarkDto bookmarkDto, Principal principal){

        User user = userService.getUserByEmail(principal.getName());
            Bookmark bookmark = new Bookmark();
            bookmark.setUser(user);
            BeanUtils.copyProperties(bookmarkDto, bookmark);

            bookmarkService.bookmarkAdd(bookmark);


        return bookmarkService.bookmarkList(user.getId()).size();
    }


    @PostMapping("/send")
    public String bookmarkSend(
            @RequestParam(name = "isbn") String isbn
    ){
        Bookmark bookmark = new Bookmark();
        bookmark.setIsbn(isbn);
        bookmarkService.bookmarkAdd(bookmark);
        return "challenges/addform";
    }


}
