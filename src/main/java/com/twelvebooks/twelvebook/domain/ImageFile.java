package com.twelvebooks.twelvebook.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "image_files")
@Getter
@Setter
public class ImageFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;

    private long length;
    private String mimeType;
    private String saveFileName;

}
