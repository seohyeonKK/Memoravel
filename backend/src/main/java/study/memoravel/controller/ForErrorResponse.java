package study.memoravel.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import study.memoravel.exception.ErrorCode;
import study.memoravel.exception.ErrorResponse;

@Controller
@RequestMapping("/api/no/send")
@ResponseBody
public class ForErrorResponse {
    @GetMapping("")
    @ApiOperation(value = "사용하지 마세요", notes = "ErrorResponseDto를 Swagger에 표시하기 위한 API")
    public ErrorResponse noSend() {
        return new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR.getMessage(), ErrorCode.INTERNAL_SERVER_ERROR.getCode());
    }
}
