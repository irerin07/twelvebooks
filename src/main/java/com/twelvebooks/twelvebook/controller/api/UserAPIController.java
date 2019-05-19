package com.twelvebooks.twelvebook.controller.api;

import com.twelvebooks.twelvebook.domain.User;
import com.twelvebooks.twelvebook.dto.UserAPIResultDto;
import com.twelvebooks.twelvebook.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/users")
@RestController
@RequiredArgsConstructor
public class UserAPIController {
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<UserAPIResultDto> getUserById(@RequestParam Long userId){
            return null;
    }

    @PostMapping
    public ResponseEntity<UserAPIResultDto> modifyUserRole(@RequestParam String roleName){
        Authentication loginUser = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUserByEmail(loginUser.getName());

        return null;
    }

}
