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
    private String booktitle;
    private String authors;
    private String publisher;

    private String startdate;
    private String enddate;
    private int days;
    private String visibility;


}
