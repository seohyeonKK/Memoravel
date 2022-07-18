package study.memoravel.controller.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Getter
@ApiModel("핸드폰 번호 수정 정보")
public class UpdatePhoneNumberRequestDto {
    @ApiModelProperty("수정할 핸드폰 번호")
    private String phoneNumber;
}
