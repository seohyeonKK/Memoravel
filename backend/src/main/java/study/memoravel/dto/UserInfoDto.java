package study.memoravel.dto;

import lombok.Getter;
import study.memoravel.controller.dto.UpdateUserInfoRequestDto;
import study.memoravel.domain.UserEntity;

import java.sql.Date;

@Getter
public class UserInfoDto {
    private final int id;
    private final String email;
    private final String nickname;
    private final String password;
    private final Date regDate;
    private final String address;
    private final String gender;
    private final String photoPath;
    private final String phoneNumber;
    private final String language;
    private String salt;
    private String jwt;

    public UserInfoDto(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.email = userEntity.getEmail();
        this.nickname = userEntity.getNickname();
        this.password = userEntity.getPassword();
        this.regDate = userEntity.getRegDate();
        this.address = userEntity.getAddress();
        this.gender = userEntity.getGender();
        this.photoPath = userEntity.getPhotoPath();
        this.phoneNumber = userEntity.getPhoneNumber();
        this.language = userEntity.getLanguage();
        this.salt = userEntity.getSalt();
        this.jwt = userEntity.getJwt();
    }

    public UserInfoDto(UpdateUserInfoRequestDto updateUserInfoRequestDto, int id) {
        this.id = id;
        this.email = updateUserInfoRequestDto.getEmail();
        this.nickname = updateUserInfoRequestDto.getNickname();
        this.password = updateUserInfoRequestDto.getPassword();
        this.regDate = updateUserInfoRequestDto.getRegDate();
        this.address = updateUserInfoRequestDto.getAddress();
        this.gender = updateUserInfoRequestDto.getGender();
        this.photoPath = updateUserInfoRequestDto.getPhotoPath();
        this.phoneNumber = updateUserInfoRequestDto.getPhoneNumber();
        this.language = updateUserInfoRequestDto.getLanguage();
    }
}
