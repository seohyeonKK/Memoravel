package study.memoravel.domain;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
@ApiModel("응답 객체")
public class Response {
    @ApiModelProperty("HTTP 상태 코드")
    private Integer code;
    @ApiModelProperty("REST API 결과")
    private Object result;
    @ApiModelProperty("메시지")
    private String message;
}
