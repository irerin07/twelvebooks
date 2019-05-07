package com.twelvebooks.twelvebook.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

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

    @Type(type="date")
    private Date startDate;

    @Type(type="date")
    private Date endDate;
    private int currentDay;
    private int days;
    private String visibility;
    private String bookStatus;
    private String booksTitle;
    private String thumbnailImage;
    private String isbn;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    @JsonBackReference
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @OneToMany(mappedBy = "challenge")
    @JsonManagedReference
    private List<Diary> diaries;

    public Challenge(){
        startDate = new Date();
        endDate = new Date();
        diaries = new ArrayList<>();
        bookStatus = "읽는중";
        currentDay = 1;
    }

}
