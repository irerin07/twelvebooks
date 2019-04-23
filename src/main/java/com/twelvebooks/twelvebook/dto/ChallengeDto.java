package com.twelvebooks.twelvebook.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class ChallengeDto {

    private String thumbnail;
    private String bookTitle;
    private String author;
    private String publisher;

    private String startDate;
    private String endDate;
    private int days;
    private String visibility;


}
