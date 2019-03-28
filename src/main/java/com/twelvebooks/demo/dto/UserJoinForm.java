package com.twelvebooks.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class UserJoinForm {

    @NotNull
    @Size(min=5, max=255)
    private String email;

    @NotNull
    @Size(min=4, max=255)
    private String passwd;

    @NotNull
    @Size(min=4, max=255)
    private String passwd2;

    @NotNull
    @Size(min=2, max=255)
    private String name;

    @NotNull
    @Size(min=2, max=255)
    private String comment;
}
