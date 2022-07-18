package study.memoravel.exception;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@ApiModel("에러 응답 정보")
public class ErrorResponse {
    @ApiModelProperty(value = "에러 메세지")
    private final String message;
    @ApiModelProperty(value = "에러 코드")
    private final String code;
    @ApiModelProperty(value = "선택적 응답값")
    private final Object optionalResult;

    public ErrorResponse(String message, String code) {
        this.message = message;
        this.code = code;
        this.optionalResult = null;
    }
}
