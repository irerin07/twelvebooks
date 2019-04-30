package com.twelvebooks.twelvebook.controller;

import com.twelvebooks.twelvebook.domain.Bookmark;
import com.twelvebooks.twelvebook.domain.User;
import com.twelvebooks.twelvebook.repository.BookmarkRepository;
import com.twelvebooks.twelvebook.repository.UserRepository;
import com.twelvebooks.twelvebook.service.BookmarkService;
import com.twelvebooks.twelvebook.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@Controller
@RequestMapping("/bookmark")
@RequiredArgsConstructor
public class BookmarkController {

    @Autowired
    BookmarkService bookmarkService;

    @Autowired
    BookmarkRepository bookmarkRepository;

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

//    @GetMapping("/list")
//    public String bookmarkList(Model model, Principal principal){
//
//        User user = userService.getUserByEmail(principal.getName());
//        List<Bookmark> bookmarks = bookmarkService.bookmarkList(user.getId());
//        User username = userService.getUserById(user.getId());
//
//        model.addAttribute("bookmarks", bookmarks);
//        model.addAttribute("username", username);
//        return "bookmark/list";
//    }


    @GetMapping("/list")
    public String bookmarklist(Model model, Principal principal) {
        User user = userService.getUserByEmail(principal.getName());
        User username = userService.getUserById(user.getId());
        List<Bookmark> bookmarks = bookmarkService.selectAllByUserId(user.getId());
        model.addAttribute("username", username);
        model.addAttribute("bookmarks",bookmarks);

        return "bookmark/list";
    }
}
