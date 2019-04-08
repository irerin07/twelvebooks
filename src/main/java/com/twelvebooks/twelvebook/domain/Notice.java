package com.twelvebooks.twelvebook.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "notices")
@Getter
@Setter
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    @Lob
    private String content;
    private Date regdate;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "notice",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<ImageFile> imageFiles;

    public Notice() {
        imageFiles = new ArrayList<>();
    }

    public void addImageFile(ImageFile imageFile) {
        if(imageFiles == null)
            imageFiles = new ArrayList<>();
        imageFile.setNotice(this);
        imageFiles.add(imageFile);
    }
}
