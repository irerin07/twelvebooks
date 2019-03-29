package com.twelvebooks.demo.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Setter
@Getter
public class SecurityUser extends User {

    private Long id;
    private String name;
    private String email;

    public SecurityUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
       super(username, password, true, true, true, true, authorities);
        System.out.println("authore" + authorities);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail(){
        return getUsername();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
