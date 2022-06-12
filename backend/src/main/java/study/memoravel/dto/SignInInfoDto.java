package study.memoravel.dto;

import lombok.Getter;
import study.memoravel.controller.dto.SignInRequestDto;

@Getter
public class SignInInfoDto {
    private final String email;
    private final String password;

    public SignInInfoDto(SignInRequestDto signInRequest) {
        this.email = signInRequest.getEmail();
        this.password = signInRequest.getPassword();
    }
}
