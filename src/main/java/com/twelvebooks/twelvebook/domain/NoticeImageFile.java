package com.twelvebooks.twelvebook.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "notice_image_files")
@Getter
@Setter
public class NoticeImageFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;

    private long length;
    private String mimeType;
    private String name;
    private String saveFileName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notice_id")
    private Notice notice;

}
