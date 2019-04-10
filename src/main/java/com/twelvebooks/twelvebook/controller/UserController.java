package com.twelvebooks.twelvebook.controller;

import com.twelvebooks.twelvebook.domain.Role;
import com.twelvebooks.twelvebook.domain.User;
import com.twelvebooks.twelvebook.dto.UserJoinForm;
import com.twelvebooks.twelvebook.repository.UserRepository;
import com.twelvebooks.twelvebook.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String login(
            @RequestParam(name = "fail",
                    required = false,
                    defaultValue = "false") String errorFlag) {
        return "users/login";
    }

    @GetMapping("/join")
    public String joinform(UserJoinForm userJoinForm, ModelMap modelMap) {

        modelMap.addAttribute("userJoinForm", userJoinForm);

        return "users/joinform";
    }

    @PostMapping("/join")
    public String join(@Valid UserJoinForm userJoinForm, BindingResult bindingResult, HttpSession session) {

        if (bindingResult.hasErrors()) {
            return "users/joinform";
        }

        if (!userJoinForm.getPasswd().equals(userJoinForm.getPasswd2())) {
            FieldError error = new FieldError("userJoinForm", "passwd2",
                    "비밀번호가 일치하지 않습니다.");
            bindingResult.addError(error);
            return "users/joinform";
        }

        User userByEmail = userService.getUserByEmail(userJoinForm.getEmail());
        if (userByEmail != null) {
            FieldError error = new FieldError("userJoinForm", "email", "중복된 이메일이 있습니다");
            bindingResult.addError(error);
            return "users/joinform";
        }

        User user = new User();
        BeanUtils.copyProperties(userJoinForm, user);


        // 비밀번호 암호화
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        user.setPasswd(passwordEncoder.encode(user.getPasswd()));

        // 권한 부여
        Role userRole = userService.getUserRole("USER");
        user.addUserRole(userRole);

        // insert
        userService.addUser(user);


        return "users/login";
    }

    @GetMapping("/mypage")
    public String mypage(@ModelAttribute("user") @Valid UserJoinForm userJoinForm, BindingResult result, Model model){

        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String email = loggedInUser.getName();

        User user = userService.getUserByEmail(email);
        String name = user.getName();
        System.out.println("mypage: " + name);
        String comment = user.getComment();
        System.out.println("mypage: " + comment);
        model.addAttribute("name", name);
        model.addAttribute("comment", comment);
        model.addAttribute("email", email);


        return "users/mypage";
    }

    @GetMapping("/modify")
    public String modifyform(){
        System.out.println("test");
        return "users/modify";
    }

//    @GetMapping("/modify")
//    public String modifyform(@ModelAttribute("user") @Valid UserJoinForm userJoinForm, BindingResult result, Model model){
//
//        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
//        String email = loggedInUser.getName();
//
//        User user = userService.getUserByEmail(email);
//        String name = user.getName();
//        String comment = user.getComment();
//        model.addAttribute("name", name);
//        model.addAttribute("comment", comment);
//        model.addAttribute("email", email);
//
//
//        return "users/modify";
//    }

    @PostMapping("/modify")
    public String modify(@RequestParam("name") String name,
                         @RequestParam("comment") String comment){

        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String email = loggedInUser.getName();

        System.out.println(name);
        System.out.println(comment);
        System.out.println(email);

       User user = userService.getUserByEmail(email);

        System.out.println(user.getName());
        System.out.println(user.getComment());

        user.setComment(comment);
        user.setName(name);

        userRepository.save(user);

        System.out.println(user.getName());
        System.out.println(user.getComment());

        return "redirect:/users/mypage";
    }

    @GetMapping("/passwdchange")
    public String passwdchangeform(Model model){
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String email = loggedInUser.getName();

        User user = userService.getUserByEmail(email);

        String passwd = user.getPasswd();

        model.addAttribute("oldpasswd", passwd);

        return "users/passwdchange";
    }

    @PostMapping("/passwdchange")
    public String passwdchange(@RequestParam("newpasswd") String newpasswd,
                               @RequestParam("newpasswd2") String newpasswd2,
                               @RequestParam("oldpasswd") String oldpasswd
    ){

        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String email = loggedInUser.getName();

        User user = userService.getUserByEmail(email);

        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        String passwd = passwordEncoder.encode(newpasswd);

        userRepository.save(user);

        return "redirect:/users/mypage";
    }


    @GetMapping("/challenge")
    public String challenge() {
        return "users/challenge";
    }

    @GetMapping("/delete")
    public String delete() {
        return "users/delete";
    }
}
