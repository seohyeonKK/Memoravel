package study.memoravel.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class Login {
    @Getter
    @Setter
    @AllArgsConstructor
    @Builder
    @ApiModel(value = "로그인 요청")
    public static class DTO {
        @ApiModelProperty(value = "이메일")
        private String email;
        @ApiModelProperty(value = "비밀번호")
        private String password;
    }
}
