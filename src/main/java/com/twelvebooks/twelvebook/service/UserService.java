package com.twelvebooks.twelvebook.service;

import com.twelvebooks.twelvebook.domain.Role;
import com.twelvebooks.twelvebook.domain.User;

public interface UserService {
    public User addUser(User user); //회원가입
    public User getUserByEmail(String email); //로그인
    public Role getUserRole(String roleName);
}
