package study.memoravel.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.sql.Date;

@Getter
@ApiModel("회원 정보 수정 정보")

public class UpdateMemberInfoRequest {

    @ApiModelProperty(value = "이메일")
    private String email;
    @ApiModelProperty(value = "별명")
    private String nickname;
    @ApiModelProperty(value = "비밀번호")
    private String password;
    @ApiModelProperty(value = "가입 일자")
    private Date regDate;
    @ApiModelProperty(value = "위도")
    private double latitude;
    @ApiModelProperty(value = "경도")
    private double longitude;
    @ApiModelProperty(value = "성별")
    private String gender;
    @ApiModelProperty(value = "프로필 사진 위치")
    private String photoPath;
    @ApiModelProperty(value = "핸드폰 번호")
    private String phoneNumber;
    @ApiModelProperty(value = "UI 언어")
    private String language;
}
