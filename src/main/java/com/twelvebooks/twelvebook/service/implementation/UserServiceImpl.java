package com.twelvebooks.twelvebook.service.implementation;

import com.twelvebooks.twelvebook.domain.Role;
import com.twelvebooks.twelvebook.domain.User;
import com.twelvebooks.twelvebook.repository.RoleRepository;
import com.twelvebooks.twelvebook.repository.UserRepository;
import com.twelvebooks.twelvebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User addUser(User user) {
        User save = userRepository.save(user);
        return save;
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    @Override
    @Transactional(readOnly = true)
    public Role getUserRole(String roleName) {
        return roleRepository.getRoleByName(roleName);
    }

    @Override
    public int emailCheck(String email) {
        int check = 0;
        check = userRepository.emailCheck(email);
        return check;
    }

}
