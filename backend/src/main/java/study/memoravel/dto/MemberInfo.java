package study.memoravel.dto;

import lombok.Getter;
import study.memoravel.controller.dto.UpdateMemberInfoRequest;
import study.memoravel.domain.MemberEntity;

import java.sql.Date;

@Getter
public class MemberInfo {
    private final long id;
    private final String email;
    private final String nickname;
    private final String password;
    private final Date regDate;
    private final double latitude;
    private final double longitude;
    private final String gender;
    private final String photoPath;
    private final String phoneNumber;
    private final String language;
    private String salt;
    private String jwt;

    public MemberInfo(MemberEntity memberEntity) {
        this.id = memberEntity.getId();
        this.email = memberEntity.getEmail();
        this.nickname = memberEntity.getNickname();
        this.password = memberEntity.getPassword();
        this.regDate = memberEntity.getRegDate();
        this.longitude = memberEntity.getLocation().getY();
        this.latitude = memberEntity.getLocation().getX();
        this.gender = memberEntity.getGender();
        this.photoPath = memberEntity.getPhotoPath();
        this.phoneNumber = memberEntity.getPhoneNumber();
        this.language = memberEntity.getLanguage();
        this.salt = memberEntity.getSalt();
        this.jwt = memberEntity.getJwt();
    }

    public MemberInfo(UpdateMemberInfoRequest updateMemberInfoRequest, long id) {
        this.id = id;
        this.email = updateMemberInfoRequest.getEmail();
        this.nickname = updateMemberInfoRequest.getNickname();
        this.password = updateMemberInfoRequest.getPassword();
        this.regDate = updateMemberInfoRequest.getRegDate();
        this.latitude = updateMemberInfoRequest.getLatitude();
        this.longitude = updateMemberInfoRequest.getLongitude();
        this.gender = updateMemberInfoRequest.getGender();
        this.photoPath = updateMemberInfoRequest.getPhotoPath();
        this.phoneNumber = updateMemberInfoRequest.getPhoneNumber();
        this.language = updateMemberInfoRequest.getLanguage();
    }
}
