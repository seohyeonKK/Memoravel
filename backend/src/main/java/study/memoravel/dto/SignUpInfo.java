package study.memoravel.dto;

import lombok.Getter;
import study.memoravel.controller.dto.SignUpRequest;

@Getter
public class SignUpInfo {
    private final String email;
    private final String nickname;
    private final String password;
    private final double longitude;
    private final double latitude;
    private final String gender;

    public SignUpInfo(SignUpRequest signUpRequest) {
        this.email = signUpRequest.getEmail();
        this.nickname = signUpRequest.getNickname();
        this.password = signUpRequest.getPassword();
        this.longitude = signUpRequest.getLongitude();
        this.latitude = signUpRequest.getLatitude();
        this.gender = signUpRequest.getGender();
    }

    public SignUpInfo(SignUpInfo signUpInfo, String password) {
        this.email = signUpInfo.getEmail();
        this.nickname = signUpInfo.getNickname();
        this.password = password;
        this.longitude = signUpInfo.getLongitude();
        this.latitude = signUpInfo.getLatitude();
        this.gender = signUpInfo.getGender();
    }

}
