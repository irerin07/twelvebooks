package com.twelvebooks.demo;

import com.twelvebooks.demo.domain.User;
import com.twelvebooks.demo.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void init(){

    }

    @Test
    public void getUserByEmail(){
        User user = userRepository.getUserByEmail("counterchord89@gmail.com");
        System.out.println(user.getName());
        System.out.println(user.getComment());
        System.out.println(user.getPasswd());
    }
}
