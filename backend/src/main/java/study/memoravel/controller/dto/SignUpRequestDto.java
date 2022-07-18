package study.memoravel.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;


@Getter
@ApiModel("회원 가입 정보")
public class SignUpRequestDto {
    @ApiModelProperty(value = "이메일")
    private String email;
    @ApiModelProperty(value = "별명")
    private String nickname;
    @ApiModelProperty(value = "비밀번호")
    private String password;
    @ApiModelProperty(value = "위도")
    private double latitude;
    @ApiModelProperty(value = "경도")
    private double longitude;
    @ApiModelProperty(value = "성별")
    private String gender;
}
