package com.twelvebooks.twelvebook.dto;


import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {


    private String thumbnailImage;
    private String title;
    private String author;
    private String publisher;
    private String isbn;
}
