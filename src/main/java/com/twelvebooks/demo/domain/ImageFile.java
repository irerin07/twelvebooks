package com.twelvebooks.demo.domain;

import javax.persistence.*;
import java.util.List;

public class ImageFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;

    private long length;
    private String mimeType;
    private String saveFileName;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private List<User> users;
}
