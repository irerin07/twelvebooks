package com.twelvebooks.demo.controller;

import com.twelvebooks.demo.domain.Role;
import com.twelvebooks.demo.domain.User;
import com.twelvebooks.demo.dto.UserJoinForm;
import com.twelvebooks.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;


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
    public String join(@Valid UserJoinForm userJoinForm, BindingResult bindingResult, HttpSession session){
        if(bindingResult.hasErrors()){
            return "users/joinform";
        }

        if(!userJoinForm.getPasswd().equals(userJoinForm.getPasswd2())){
            FieldError error = new FieldError("userJoinForm","rePassword",
                    "비밀번호가 일치하지 않습니다.");
            bindingResult.addError(error);
            return "users/joinform";
        }

        User userByEmail = userService.getUserByEmail(userJoinForm.getEmail());
        if(userByEmail!=null){
            FieldError error = new FieldError("userJoinForm","email","중복된 이메일이 있습니다");
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
        User saved = userService.addUser(user);



        return "users/login";
    }

        @GetMapping("/welcome")
        public String welcome () {
            return "index";
        }

        @GetMapping("/challenge")
        public String challenge () {
            return "users/challenge";
        }

        @GetMapping("/delete")
        public String delete () {
            return "users/delete";
        }
    }
