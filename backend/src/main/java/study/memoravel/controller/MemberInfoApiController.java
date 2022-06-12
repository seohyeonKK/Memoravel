package study.memoravel.controller;


import io.jsonwebtoken.ExpiredJwtException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import study.memoravel.annotation.Auth;
import study.memoravel.aop.MemberContext;
import study.memoravel.controller.dto.MemberInfoResponseDto;
import study.memoravel.controller.dto.UpdateMemberInfoRequestDto;
import study.memoravel.controller.dto.UpdatePhoneNumberRequestDto;
import study.memoravel.domain.Response;
import study.memoravel.dto.MemberInfoDto;
import study.memoravel.service.MemberService;
import study.memoravel.service.SMSService;

@RestController
@RequestMapping("/api/user")
@ResponseBody
@RequiredArgsConstructor
public class MemberInfoApiController {
    private final MemberService memberService;
    private final SMSService smsService;

    @GetMapping("phone-number/{phoneNumber}/authentication")
    @ApiOperation(value = "핸드폰 번호 인증", notes = "이미 가입된 유저의 핸드폰 번호와 같은 번호인지 확인하고 같은 번호가 없다면, 인증번호를 반환한다.")
    public Response getPhoneAuthentication(@ApiParam(value = "핸드폰 번호(String,\"-\"제외하고)", required = true) @PathVariable("phoneNumber") String phoneNumber) {
        if (memberService.checkPhoneNumber(phoneNumber)) {
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
    @Auth
    public Response putPhoneNumber(@ApiParam(value = "핸드폰 번호(String,\"-\"제외하고)", required = true) @RequestBody UpdatePhoneNumberRequestDto updatePhoneNumberRequestDto) {
        try {
            int id = MemberContext.getCurrentMemberId();
            memberService.setPhoneNumber(id, updatePhoneNumberRequestDto.getPhoneNumber());
            return Response.builder().code(200).result(updatePhoneNumberRequestDto).message("success set phone number").build();
        } catch (ExpiredJwtException e) {
            return Response.builder().code(500).result(e).message("failed set phone number").build();
        }
    }

    @GetMapping("info")
    @ApiOperation(value = "유저 정보 반환", notes = "헤더의 JWT 에 해당하는 유저 정보를 반환한다.")
    public Response getUserInfo() {
        try {
            int id = MemberContext.getCurrentMemberId();
            MemberInfoDto userInfo = memberService.getMemberInfo(id);
            MemberInfoResponseDto userInfoResponse = new MemberInfoResponseDto(userInfo);
            return Response.builder().code(200).result(userInfoResponse).message("success get user info").build();
        } catch (ExpiredJwtException e) {
            return Response.builder().code(500).result(e).message("failed get user info \n token is expired").build();
        }
    }

    @PostMapping("info")
    @ApiOperation(value = "유저 정보 수정", notes = "헤더의 JWT 에 해당하는 유저 정보를 전송한 유저 정보로 수정한다.")
    public Response postUserInfo(@RequestBody UpdateMemberInfoRequestDto updateUserInfoRequest) {
        try {
            int id = MemberContext.getCurrentMemberId();
            MemberInfoDto userInfo = new MemberInfoDto(updateUserInfoRequest, id);
            memberService.updateMemberInfo(userInfo);
            return Response.builder().code(200).result(updateUserInfoRequest).message("success get user info").build();

        } catch (ExpiredJwtException e) {
            return Response.builder().code(500).result(e).message("failed get user info \n token is expired").build();
        } catch (Exception e) {
            return Response.builder().code(500).result(e).message("failed get user info").build();
        }
    }

}
