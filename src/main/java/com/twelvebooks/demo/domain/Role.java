package com.twelvebooks.demo.domain;

import lombok.Getter;
import lombok.Setter;
import sun.plugin2.message.GetAppletMessage;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
}
