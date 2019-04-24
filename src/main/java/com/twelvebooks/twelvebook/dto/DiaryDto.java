package com.twelvebooks.twelvebook.dto;

import com.twelvebooks.twelvebook.domain.Diary;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DiaryDto {

    public DiaryDto(String content, int day, long chalid){
        this.content = content;
        this.day = day;
        this.chalid = chalid;

    }

    private String content;
    private int day;
    private long chalid;



}
