package study.memoravel.controller.userInfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import study.memoravel.domain.UserEntity;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ApiModel("유저 정보")

public class UserInfo {
    @ApiModelProperty(value = "이메일")
    private String email;
    @ApiModelProperty(value = "별명")
    private String nickname;
    @ApiModelProperty(value = "비밀번호")
    private String password;
    @ApiModelProperty(value = "가입 일자")
    private Date regDate;
    @ApiModelProperty(value = "주소")
    private String address;
    @ApiModelProperty(value = "성별")
    private String gender;
    @ApiModelProperty(value = "프로필 사진 위치")
    private String photoPath;
    @ApiModelProperty(value = "핸드폰 번호")
    private String phoneNumber;
    @ApiModelProperty(value = "UI 언어")
    private String language;

    public UserInfo(UserEntity userEntity) {
        email = userEntity.getEmail();
        nickname = userEntity.getNickname();
        password = userEntity.getPassword();
        regDate = userEntity.getRegDate();
        address = userEntity.getAddress();
        gender = userEntity.getGender();
        photoPath = userEntity.getPhotoPath();
        phoneNumber = userEntity.getPhoneNumber();
        language = userEntity.getLanguage();
    }
}
