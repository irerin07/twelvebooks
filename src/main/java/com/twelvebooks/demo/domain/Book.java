package com.twelvebooks.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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

    @OneToMany(mappedBy = "book")
    private List<Challenge> challenges;

}
