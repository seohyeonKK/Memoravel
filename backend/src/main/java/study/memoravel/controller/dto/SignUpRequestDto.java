package study.memoravel.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@Builder
@ApiModel("계정 가입 정보")
public class SignUpRequestDto {
    @ApiModelProperty(value = "이메일")
    private String email;
    @ApiModelProperty(value = "별명")
    private String nickname;
    @ApiModelProperty(value = "비밀번호")
    private String password;
    @ApiModelProperty(value = "주소")
    private String address;
    @ApiModelProperty(value = "성별")
    private String gender;
    @ApiModelProperty(hidden = true)
    private String salt;
}
