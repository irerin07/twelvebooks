package com.twelvebooks.twelvebook.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "diaries")
@Getter
@Setter
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int days;
    private String content;

//    @Column(name = "challenge_id")
//    private Long challengeId;

    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "challenge_id", insertable = false, updatable = false)
    @JoinColumn(name = "challenge_id")
    @JsonBackReference
    private Challenge challenge;

}
