package com.twelvebooks.twelvebook.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BookmarkDto {
    private String result;
    private Long BookmarkId;

    public BookmarkDto(String result) {
        this.result = result;

    }
}
