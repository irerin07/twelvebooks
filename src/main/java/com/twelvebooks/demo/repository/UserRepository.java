package com.twelvebooks.demo.repository;

import com.twelvebooks.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    //email에 해당하는 User 가져오기
    @Query("SELECT u FROM User u WHERE u.email =:email")
    public User getUserByEmail(@Param("email") String email);

    //User전체 리스트 가져오기
    @Query("SELECT u FROM User u ORDER BY u.id DESC")
    public List<User> getUsers();
}
