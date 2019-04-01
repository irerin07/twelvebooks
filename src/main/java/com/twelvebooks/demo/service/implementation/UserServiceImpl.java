package com.twelvebooks.demo.service.implementation;

import com.twelvebooks.demo.domain.Role;
import com.twelvebooks.demo.domain.User;
import com.twelvebooks.demo.repository.RoleRepository;
import com.twelvebooks.demo.repository.UserRepository;
import com.twelvebooks.demo.service.UserService;
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

}
