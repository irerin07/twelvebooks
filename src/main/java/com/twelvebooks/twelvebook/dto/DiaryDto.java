package com.twelvebooks.twelvebook.dto;

import com.twelvebooks.twelvebook.domain.Diary;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@ToString
public class DiaryDto {

    private long id;
    @NonNull
    @Size(min = 30)
    private String content;

    private int days;

    private long chalid;



}
