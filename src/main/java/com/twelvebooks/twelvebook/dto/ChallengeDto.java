package com.twelvebooks.twelvebook.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ChallengeDto {

    private String thumbnailImage;
    private String bookTitle;
    private String authors;
    private String publisher;
    private String isbn;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
    private Date startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
    private Date endDate;
    private int days;
    private String visibility;


}
