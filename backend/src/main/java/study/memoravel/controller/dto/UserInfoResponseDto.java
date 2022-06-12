package study.memoravel.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import study.memoravel.dto.UserInfoDto;

import java.sql.Date;

@Getter
@ApiModel("유저 정보")
public class UserInfoResponseDto {

    @ApiModelProperty(value = "이메일")
    private final String email;
    @ApiModelProperty(value = "별명")
    private final String nickname;
    @ApiModelProperty(value = "비밀번호")
    private final String password;
    @ApiModelProperty(value = "가입 일자")
    private final Date regDate;
    @ApiModelProperty(value = "주소")
    private final String address;
    @ApiModelProperty(value = "성별")
    private final String gender;
    @ApiModelProperty(value = "프로필 사진 위치")
    private final String photoPath;
    @ApiModelProperty(value = "핸드폰 번호")
    private final String phoneNumber;
    @ApiModelProperty(value = "UI 언어")
    private final String language;

    public UserInfoResponseDto(UserInfoDto userInfo) {
        this.email = userInfo.getEmail();
        this.nickname = userInfo.getNickname();
        this.password = userInfo.getPassword();
        this.regDate = userInfo.getRegDate();
        this.address = userInfo.getAddress();
        this.gender = userInfo.getGender();
        this.photoPath = userInfo.getPhotoPath();
        this.phoneNumber = userInfo.getPhoneNumber();
        this.language = userInfo.getLanguage();
    }
}
