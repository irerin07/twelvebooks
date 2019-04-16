package com.twelvebooks.twelvebook.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
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
    private String visibility;
    private String status;
    private String booksTitle;
    private String thumbnailImage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "challenge")
    private List<Diary> diaries;

    public Challenge(){
        startDate = new Date();
        endDate = new Date();
        diaries = new ArrayList<>();
    }

}
