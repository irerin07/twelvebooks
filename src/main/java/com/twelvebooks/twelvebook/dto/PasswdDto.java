package com.twelvebooks.twelvebook.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class PasswdDto {

    @NotNull
    @Size(min=4, max=255, message = "비밀번호는 최소 4글자 이상 입력해주세요.")
    @Pattern(regexp = "\\S+", message = "공백은 포함될 수 없습니다.")
    private String oldpasswd;

    @NotNull
    @Size(min=4, max=255, message = "비밀번호는 최소 4글자 이상 입력해주세요.")
    @Pattern(regexp = "\\S+", message = "공백은 포함될 수 없습니다.")
    private String newpasswd;

    @NotNull
    @Size(min=4, max=255, message = "비밀번호는 최소 4글자 이상 입력해주세요.")
    @Pattern(regexp = "\\S+", message = "공백은 포함될 수 없습니다.")
    private String newpasswd2;
}
