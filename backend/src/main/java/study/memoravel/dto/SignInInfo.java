package study.memoravel.dto;

import lombok.Getter;
import study.memoravel.controller.dto.SignInRequest;

@Getter
public class SignInInfo {
    private final String email;
    private final String password;

    public SignInInfo(SignInRequest signInRequest) {
        this.email = signInRequest.getEmail();
        this.password = signInRequest.getPassword();
    }
}
