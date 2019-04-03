package com.twelvebooks.twelvebook.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
@Setter
@Getter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String isbn;
    private String title;
    private String author;
    private String translator;
    private String thumbnailImage;
    private String publisher;

    @OneToMany(mappedBy = "book")
    private List<Challenge> challenges;

    public Book(){
        challenges = new ArrayList<>();
    }

}
