package study.memoravel.controller;


import io.jsonwebtoken.ExpiredJwtException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import study.memoravel.controller.dto.UpdatePhoneNumberRequestDto;
import study.memoravel.controller.dto.UpdateUserInfoRequestDto;
import study.memoravel.controller.dto.UserInfoResponseDto;
import study.memoravel.domain.Response;
import study.memoravel.dto.UserInfoDto;
import study.memoravel.service.SMSService;
import study.memoravel.service.UserService;
import study.memoravel.util.JWT;

import java.util.Map;

@RestController
@RequestMapping("/api/user")
@ResponseBody
public class UserInfoApiController {
    private final UserService userService;
    private final SMSService smsService;

    @Autowired
    public UserInfoApiController(UserService userService, SMSService smsService) {
        this.userService = userService;
        this.smsService = smsService;
    }


    @GetMapping("phone-number/{phoneNumber}/authentication")
    @ApiOperation(value = "핸드폰 번호 인증", notes = "이미 가입된 유저의 핸드폰 번호와 같은 번호인지 확인하고 같은 번호가 없다면, 인증번호를 반환한다.")
    public Response getPhoneAuthentication(@ApiParam(value = "핸드폰 번호(String,\"-\"제외하고)", required = true) @PathVariable("phoneNumber") String phoneNumber) {
        if (userService.checkPhoneNumber(phoneNumber)) {
            try {
                String randomNumber = smsService.sendMessage(phoneNumber);
                return Response.builder().code(200).result(randomNumber).message("success phone number authentication").build();
            } catch (Exception e) {
                return Response.builder().code(500).result(e).message("failed phone number authentication\n cool sms error").build();
            }
        } else {
            return Response.builder().code(500).result(null).message("failed phone number authentication\n already using phone number").build();
        }
    }

    @PutMapping("phone-number")
    @ApiOperation(value = "핸드폰 번호 저장", notes = "헤더의 JWT 에 해당하는 유저의 핸드폰 번호를 저장한다.")
    public Response putPhoneNumber(@ApiParam(value = "핸드폰 번호(String,\"-\"제외하고)", required = true) @RequestBody UpdatePhoneNumberRequestDto updatePhoneNumberRequestDto,
                                   @RequestHeader Map<String, Object> header) {
        try {
            int userId = JWT.getIdFromJWT((String) (header.get("authorization")));
            userService.setPhoneNumber(userId, updatePhoneNumberRequestDto.getPhoneNumber());
            return Response.builder().code(200).result(updatePhoneNumberRequestDto).message("success set phone number").build();
        } catch (ExpiredJwtException e) {
            return Response.builder().code(500).result(e).message("failed set phone number").build();
        }
    }

    @GetMapping("info")
    @ApiOperation(value = "유저 정보 반환", notes = "헤더의 JWT 에 해당하는 유저 정보를 반환한다.")
    public Response getUserInfo(@RequestHeader Map<String, Object> header) {
        try {
            int userId = JWT.getIdFromJWT((String) (header.get("authorization")));
            UserInfoDto userInfo = userService.getUserInfo(userId);
            UserInfoResponseDto userInfoResponse = new UserInfoResponseDto(userInfo);
            return Response.builder().code(200).result(userInfoResponse).message("success get user info").build();
        } catch (ExpiredJwtException e) {
            return Response.builder().code(500).result(e).message("failed get user info \n token is expired").build();
        }
    }

    @PostMapping("info")
    @ApiOperation(value = "유저 정보 수정", notes = "헤더의 JWT 에 해당하는 유저 정보를 전송한 유저 정보로 수정한다.")
    public Response postUserInfo(@RequestHeader Map<String, Object> header, @RequestBody UpdateUserInfoRequestDto updateUserInfoRequest) {
        try {
            int userId = JWT.getIdFromJWT((String) (header.get("authorization")));
            UserInfoDto userInfo = new UserInfoDto(updateUserInfoRequest, userId);
            userService.updateUserInfo(userInfo);
            return Response.builder().code(200).result(updateUserInfoRequest).message("success get user info").build();

        } catch (ExpiredJwtException e) {
            return Response.builder().code(500).result(e).message("failed get user info \n token is expired").build();
        } catch (Exception e) {
            return Response.builder().code(500).result(e).message("failed get user info").build();
        }
    }

}
