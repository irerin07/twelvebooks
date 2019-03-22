package com.twelvebooks.demo.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ImageFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;

    private long length;
    private String mimeType;
    private String saveFileName;
}
