package study.memoravel.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Getter
@ApiModel(value = "토큰 재발급 요청")
public class ReAuthRequest {
    @ApiModelProperty(value = "기존 토큰")
    private String oldToken;
}
