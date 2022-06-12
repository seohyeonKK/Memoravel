package study.memoravel.dto;

import lombok.Getter;
import study.memoravel.controller.dto.SignUpRequestDto;

@Getter
public class SignUpInfoDto {
    private final String email;
    private final String nickname;
    private final String password;
    private final String address;
    private final String gender;

    public SignUpInfoDto(SignUpRequestDto signUpRequest) {
        this.email = signUpRequest.getEmail();
        this.nickname = signUpRequest.getNickname();
        this.password = signUpRequest.getPassword();
        this.address = signUpRequest.getAddress();
        this.gender = signUpRequest.getGender();
    }

    public SignUpInfoDto(SignUpInfoDto signUpInfo, String password) {
        this.email = signUpInfo.getEmail();
        this.nickname = signUpInfo.getNickname();
        this.password = password;
        this.address = signUpInfo.getAddress();
        this.gender = signUpInfo.getGender();
    }

}
