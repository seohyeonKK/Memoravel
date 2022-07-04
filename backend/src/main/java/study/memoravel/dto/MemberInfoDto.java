package study.memoravel.dto;

import lombok.Getter;
import study.memoravel.controller.dto.UpdateMemberInfoRequestDto;
import study.memoravel.domain.MemberEntity;

import java.sql.Date;

@Getter
public class MemberInfoDto {
    private final long id;
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

    public MemberInfoDto(MemberEntity memberEntity) {
        this.id = memberEntity.getId();
        this.email = memberEntity.getEmail();
        this.nickname = memberEntity.getNickname();
        this.password = memberEntity.getPassword();
        this.regDate = memberEntity.getRegDate();
        this.address = memberEntity.getAddress();
        this.gender = memberEntity.getGender();
        this.photoPath = memberEntity.getPhotoPath();
        this.phoneNumber = memberEntity.getPhoneNumber();
        this.language = memberEntity.getLanguage();
        this.salt = memberEntity.getSalt();
        this.jwt = memberEntity.getJwt();
    }

    public MemberInfoDto(UpdateMemberInfoRequestDto updateMemberInfoRequest, int id) {
        this.id = id;
        this.email = updateMemberInfoRequest.getEmail();
        this.nickname = updateMemberInfoRequest.getNickname();
        this.password = updateMemberInfoRequest.getPassword();
        this.regDate = updateMemberInfoRequest.getRegDate();
        this.address = updateMemberInfoRequest.getAddress();
        this.gender = updateMemberInfoRequest.getGender();
        this.photoPath = updateMemberInfoRequest.getPhotoPath();
        this.phoneNumber = updateMemberInfoRequest.getPhoneNumber();
        this.language = updateMemberInfoRequest.getLanguage();
    }
}
