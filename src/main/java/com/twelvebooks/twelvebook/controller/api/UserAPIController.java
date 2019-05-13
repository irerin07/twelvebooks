package com.twelvebooks.twelvebook.controller.api;

import com.twelvebooks.twelvebook.dto.UserAPIResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/users")
@RestController
@RequiredArgsConstructor
public class UserAPIController {


    @GetMapping
    public ResponseEntity<UserAPIResultDto> getUserById(@RequestParam Long userId){
            return null;
    }

    @PostMapping
    public ResponseEntity<UserAPIResultDto> modifyUserRole(){
        return null;
    }

}
