package com.twelvebooks.demo.service;

import com.twelvebooks.demo.domain.Role;
import com.twelvebooks.demo.domain.User;

public interface UserService {
    public User addUser(User user); //회원가입
    public User getUserByEmail(String email); //로그인
    public Role getUserRole(String roleName);
}
