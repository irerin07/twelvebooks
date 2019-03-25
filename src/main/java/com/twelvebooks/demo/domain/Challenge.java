package com.twelvebooks.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "challenges")
@Getter
@Setter
public class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date startDate;
    private Date endDate;
    private int days;
    private boolean visibility;
    private boolean finished;
    private String status;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "challenge")
    private List<Diary> diaries;
}
