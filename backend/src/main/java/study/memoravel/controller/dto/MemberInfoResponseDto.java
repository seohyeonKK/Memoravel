package study.memoravel.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import study.memoravel.dto.MemberInfoDto;

import java.sql.Date;

@Getter
@ApiModel("회원 정보")
public class MemberInfoResponseDto {

    @ApiModelProperty(value = "이메일")
    private final String email;
    @ApiModelProperty(value = "별명")
    private final String nickname;
    @ApiModelProperty(value = "가입 일자")
    private final Date regDate;
    @ApiModelProperty(value = "성별")
    private final String gender;
    @ApiModelProperty(value = "프로필 사진 위치")
    private final String photoPath;
    @ApiModelProperty(value = "핸드폰 번호")
    private final String phoneNumber;
    @ApiModelProperty(value = "UI 언어")
    private final String language;
    @ApiModelProperty(value = "위도")
    private final double latitude;
    @ApiModelProperty(value = "경도")
    private final double longitude;

    public MemberInfoResponseDto(MemberInfoDto memberInfo) {
        this.email = memberInfo.getEmail();
        this.nickname = memberInfo.getNickname();
        this.regDate = memberInfo.getRegDate();
        this.latitude = memberInfo.getLatitude();
        this.longitude = memberInfo.getLongitude();
        this.gender = memberInfo.getGender();
        this.photoPath = memberInfo.getPhotoPath();
        this.phoneNumber = memberInfo.getPhoneNumber();
        this.language = memberInfo.getLanguage();
    }
}
