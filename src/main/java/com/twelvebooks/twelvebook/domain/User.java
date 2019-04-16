package com.twelvebooks.twelvebook.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String comment;
    private String email;
    private String passwd;
    private Date regdate;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    private Set<Role> roles;

    @OneToMany(mappedBy = "user")
    private List<Challenge> challenges;


    @OneToMany(mappedBy = "user")
    private List<Notice> notices;

    @OneToMany(mappedBy = "user")
    private List<Bookmark> bookmarks;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "imagefile_id", referencedColumnName = "id")
    private ImageFile imageFile;

    public User(){
        regdate = new Date();
        roles = new HashSet<>();
        challenges = new ArrayList<>();
        bookmarks = new ArrayList<>();
    }

    public void addUserRole(Role role){
        this.roles.add(role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                ", email='" + email + '\'' +
                ", passwd='" + passwd + '\'' +
                ", regdate=" + regdate +
                ", roles=" + roles +
                ", challenges=" + challenges +
                ", notices=" + notices +
                ", imageFile=" + imageFile +
                '}';
    }
}
