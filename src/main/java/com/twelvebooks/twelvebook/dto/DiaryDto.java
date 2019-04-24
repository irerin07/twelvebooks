package com.twelvebooks.twelvebook.dto;

import com.twelvebooks.twelvebook.domain.Diary;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class DiaryDto {

//    public DiaryDto(String content, int days, long chalid){
//        this.content = content;
//        this.days = days;
//        this.chalid = chalid;
//    }

    private String content;
    private int days;
    private long chalid;



}
