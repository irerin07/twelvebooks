package com.twelvebooks.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "diaries")
@Getter
@Setter
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int day;
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private List<User> users;

    @ManyToOne
    @JoinColumn(name = "challenge_id")
    private  List<Challenge> challenges;
}
