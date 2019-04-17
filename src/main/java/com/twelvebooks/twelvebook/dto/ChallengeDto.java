package com.twelvebooks.twelvebook.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Getter
@Setter
@ToString
public class ChallengeDto {

    private String bookTitle;
    private Date startDate;
    private Date endDate;
    private String bookStatus;


}
